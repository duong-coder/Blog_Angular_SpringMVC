import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AccountLogin } from '../model/acccount-login';
import { AccountService } from '../service/account.service';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  constructor(
    private accountService: AccountService,
    private router: Router
  ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(req).pipe(
      catchError(err => {
        const account = this.accountService.getCurrentAccountValue;
        if (err.status === 401 && account != null && !account.rememberMe) {
          console.log('ERROR', err);
          this.accountService.logout();
          // this.router.navigateByUrl('/login');
          location.replace('/login');
        }

        // const error = err.error.message || err.statusText;
        return throwError(err);
      })
    );
  }

}
