import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AccountLogin } from '../model/acccount-login';
import { JwtToken } from '../model/token';
import { JwttokenService } from './jwttoken.service';
import { Account } from '../model/account';
import { ResponseEnity } from '../model/response-entity';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private URL_LOGIN_APP = '/api/authenticate';
  private URL_GET_ACCOUNT: string = '/api/account/0773314448';

  constructor(
    private http: HttpClient,
    private jwttokenService: JwttokenService
    ) {

  }

  getAccountByPhone(): Observable<ResponseEnity<Account>> {
    // const header = this.jwttokenService.getHeaderWithAuthorization();
    // const options = {
    //   headers: header,
    // };
    return this.http.get<ResponseEnity<Account>>(this.URL_GET_ACCOUNT);
  }

  login(accountLogin: AccountLogin): Observable<JwtToken> {
    return this.http.post<JwtToken>(this.URL_LOGIN_APP, accountLogin);
  }
}
