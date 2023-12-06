import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IAccount} from '../../model/account/iaccount';
import {IEmployeeAccount} from '../../model/account/i-employee-account';
import {Password} from '../../model/classDTO/password';

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {
  API_URL = 'http://localhost:8080/api/account';
  constructor(private http: HttpClient) { }

  // NhiVP lay account theo username
  getAccountByUsername(username: string): Observable<IAccount> {
    return this.http.get<IAccount>(`${(this.API_URL)}/byUsername/${username}`);
  }
  // NhiVP lay danh sach username
  getAllUsername(): Observable<string[]> {
    return this.http.get<string[]>(this.API_URL + '/list-Username');
  }
  // NhiVP tao tai khoan cho nhan vien
  createAccount(employeeAccount: IEmployeeAccount): Observable<IEmployeeAccount> {
    return this.http.post<IEmployeeAccount>(this.API_URL + '/create-Account', employeeAccount);}

  // AnDVH thay đổi mật khẩu
  public updatePassword(accountId: number, password: Password): Observable<void> {
    return this.http.patch<void>(`${this.API_URL}/update/password/${accountId}`, password);
  }
}
