import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TypeCustomer} from '../type-customer';
const API_URL = 'http://localhost:8080';
@Injectable({
  providedIn: 'root'
})
export class TypeCustomerService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<TypeCustomer[]> {
    return this.httpClient.get<TypeCustomer[]>(API_URL + '/api/customerType');
  }
}
