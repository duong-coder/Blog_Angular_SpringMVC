import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AccountLogin } from '../model/acccount-login';
import { JwtToken } from '../model/token';
import { JwttokenService } from './jwttoken.service';
import { Account } from '../model/account';
import { ResponseEnity } from '../model/response-entity';
import { MappingService } from './mapping.service';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private URL_LOGIN_APP = '/api/authenticate';
  private URL_GET_ACCOUNT = '/api/account/duongnh';
  private URL_UPDATE_ACCOUNT = '/api/account';

  constructor(
    private http: HttpClient,
    private jwttokenService: JwttokenService,
    private mappingServide: MappingService
  ) {

  }

  getAccountByPhone(): Observable<ResponseEnity<Account>> {
    // const header = this.jwttokenService.getHeaderWithAuthorization();
    // const options = {
    //   headers: header,
    // };
    const observableAccountConvert = this.http.get<ResponseEnity<Account>>(this.URL_GET_ACCOUNT).pipe(
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

  updateByUsername(account: Account): Observable<ResponseEnity<Account>>{

    return this.http.put<ResponseEnity<Account>>(this.URL_UPDATE_ACCOUNT, account);
  }

  login(accountLogin: AccountLogin): Observable<JwtToken> {
    return this.http.post<JwtToken>(this.URL_LOGIN_APP, accountLogin);
  }
}
