import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwttokenService } from '../service/jwttoken.service';

@Injectable()
export class HttpTokenInterceptor implements HttpInterceptor {

  constructor(
    private jwtTokenService: JwttokenService
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const headerConfig: any = {
      'Content-Type': 'application/json',
      Accept: 'application/json'
    };

    const token = this.jwtTokenService.getTokenInLocalStorage();
    if (token) {
      headerConfig.Authorization = `Bearer ${token}`;
    }

    const reqNew = request.clone({
      setHeaders: headerConfig
    });

    return next.handle(reqNew);
  }
}
