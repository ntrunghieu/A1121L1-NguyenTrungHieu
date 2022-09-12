import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../employee';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(API_URL + '/employee');
  }
  findByIdEmployee(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(API_URL + '/employee' + '/' + id);
  }
  updateEmployee(id: number, employee1): Observable<Employee> {
    return this.httpClient.put<Employee>(API_URL + '/employee/'+id, employee1);
  }
  delete(id: number): Observable<Employee> {
    return this.httpClient.delete<Employee>(API_URL + '/employee'+'/'+id);
  }
  createEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(API_URL + '/employee', employee);
  }
  searchName(value: string): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(API_URL + '/employee?name_like=' + value);
  }
}
