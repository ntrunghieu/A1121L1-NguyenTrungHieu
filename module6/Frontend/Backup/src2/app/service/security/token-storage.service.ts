import { Injectable } from '@angular/core';
import {JwtHelperService} from '@auth0/angular-jwt';

const USER_KEY = 'auth-user';
const TOKEN_KEY = 'auth-token';
@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor(private jwtHelper: JwtHelperService) {
  }
  public isAuthenticated(): boolean {
    const token = this.getToken();

    return !this.jwtHelper.isTokenExpired(token);
  }

  signOut() {
    localStorage.clear();
    sessionStorage.clear();
  }

  saveTokenLocal(token: any) {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, token);
  }

  saveTokenSession(token: any) {
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.setItem(TOKEN_KEY, token);
  }

  saveUserLocal(data: any) {
    localStorage.removeItem(USER_KEY);
    localStorage.setItem(USER_KEY, JSON.stringify(data));
  }

  saveUserSession(data: any) {
    sessionStorage.removeItem(USER_KEY);
    sessionStorage.setItem(USER_KEY, JSON.stringify(data));
  }

  getToken(): string {
    if (localStorage.getItem(TOKEN_KEY) !== null) {
      return localStorage.getItem(TOKEN_KEY);
    } else {
      return sessionStorage.getItem(TOKEN_KEY);
    }
  }

  getUser() {
    if (localStorage.getItem(USER_KEY) !== null) {
      return JSON.parse(localStorage.getItem(USER_KEY));
    } else {
      return JSON.parse(sessionStorage.getItem(USER_KEY));
    }
  }
}
