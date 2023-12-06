import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const AUTH_API = 'http://localhost:8080/auth/login';
@Injectable({
    providedIn: 'root'
})
export class SecurityServiceService {
    httpOptions: any;
    isLoggedIn: boolean;
    constructor(private http: HttpClient) {
        this.httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            }),
            'Access-Control-Allow-Origin': 'http://localhost:4200',
            'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
        };
    }
    login(user: any): Observable<any> {
        return this.http.post(AUTH_API, {
            username: user.username,
            password: user.password
        }, this.httpOptions);
    }
}
