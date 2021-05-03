import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwttokenService {
  public KEY_TOKEN_LOCALSTORAGE = 'id_token';

  constructor() { }

  getTokenInLocalStorage(): string {
    const token = localStorage.getItem(this.KEY_TOKEN_LOCALSTORAGE);
    if (token != null) {
      return token;
    }

    return null;
  }

  addTokenInLocalStorage(token: string): void{
    localStorage.setItem(this.KEY_TOKEN_LOCALSTORAGE, token);
  }

  removeTokenInLocalStorage(): void{
    localStorage.removeItem(this.KEY_TOKEN_LOCALSTORAGE);
  }

  getHeaderWithAuthorization(): HttpHeaders {
    const token = this.getTokenInLocalStorage();
    const optionsHeader = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

    return optionsHeader;
  }
}
