import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { JwttokenService } from '../service/jwttoken.service';
import { catchError, switchMap } from 'rxjs/operators';
import { AccountService } from '../service/account.service';

@Injectable()
export class HttpTokenInterceptor implements HttpInterceptor {

  private isRefreshToken: boolean = false;

  constructor(
    private jwtTokenService: JwttokenService,
    private accountService: AccountService
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    request = this.addToken(request);
    const account = this.accountService.getCurrentAccountValue;

    return next.handle(request).pipe(catchError(error => {
      if (error instanceof HttpErrorResponse && error.status === 401 && account.rememberMe) {
        return this.handle401Error(request, next);
      } else {
        return throwError(error);
      }
    }));
  }

  addToken(request: HttpRequest<any>): HttpRequest<any> {
    const headerConfig: any = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      // 'Access-Control-Allow-Origin': 'http://localhost:4200'
    };

    const token = this.jwtTokenService.getTokenInLocalStorage();
    if (token) {
      headerConfig.Authorization = `Bearer ${token}`;
    }

    const newReq = request.clone({
      setHeaders: headerConfig
    });

    return newReq;
  }

  handle401Error(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (!this.isRefreshToken) {
      this.isRefreshToken = true;
      return this.accountService.refreshToken().pipe(switchMap(tokenObj => {
        this.isRefreshToken = false;

        return next.handle(this.addToken(request));
      }));
    } else {
      return next.handle(this.addToken(request));
    }
  }
}
