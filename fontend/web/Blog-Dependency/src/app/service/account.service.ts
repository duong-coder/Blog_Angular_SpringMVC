import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AccountLogin } from '../model/acccount-login';
import { JwtToken } from '../model/token';
import { JwttokenService } from './jwttoken.service';
import { Account } from '../model/account';
import { ResponseEnity } from '../model/response-entity';
import { MappingService } from './mapping.service';
import { Constant } from './constant';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private URL_LOGIN_APP ='/authenticate';
  private URL_GET_ACCOUNT = '/account/duongnh';
  private URL_GET_ACCOUNT_LINK_SOCIAL_NETWORK = '/account/duongnh/link-social-network';
  private URL_UPDATE_ACCOUNT = '/account';

  private NAME_ACCOUNT_IN_STORAGE = 'accountCurrent';
  private currentAccountSubject: BehaviorSubject<AccountLogin>;
  private currentAccount: Observable<AccountLogin>;

  constructor(
    private http: HttpClient,
    private jwttokenService: JwttokenService,
    private mappingServide: MappingService
  ) {
    this.currentAccountSubject = new BehaviorSubject<AccountLogin>(JSON.parse(localStorage.getItem(this.NAME_ACCOUNT_IN_STORAGE)));
    this.currentAccount = this.currentAccountSubject.asObservable();
  }

  public get getCurrentAccountValue(): AccountLogin {
    return this.currentAccountSubject.value;
  }

  getAccountByPhone(): Observable<ResponseEnity<Account>> {
    const observableAccountConvert = this.http.get<ResponseEnity<Account>>(environment.apiUrl + this.URL_GET_ACCOUNT).pipe(
      map((account) => {
        if (account.status === 200) {
          const accountBE = account.body;
          account.body = this.mappingServide.mappingAccount(accountBE);

          return account;
        }
        return account;
      })
    );

    return observableAccountConvert;
  }
  getLinkSocialNetworkById(): Observable<ResponseEnity<Account>> {
    return this.http.get<ResponseEnity<Account>>(environment.apiUrl + this.URL_GET_ACCOUNT_LINK_SOCIAL_NETWORK);
  }

  updateByUsername(account: Account): Observable<ResponseEnity<Account>> {

    return this.http.put<ResponseEnity<Account>>(environment.apiUrl + this.URL_UPDATE_ACCOUNT, account);
  }

  login(accountLogin: AccountLogin): Observable<JwtToken> {
    return this.http.post<JwtToken>(environment.apiUrl + this.URL_LOGIN_APP, accountLogin)
      .pipe(map(tokenObj => {
        localStorage.setItem(this.NAME_ACCOUNT_IN_STORAGE, JSON.stringify(accountLogin));
        this.jwttokenService.addTokenInLocalStorage(tokenObj.id_token);

        this.currentAccountSubject.next(accountLogin);

        return tokenObj;
      }));
  }

  logout(): void {
    localStorage.removeItem(this.NAME_ACCOUNT_IN_STORAGE);
    this.currentAccountSubject.next(null);
  }
}
