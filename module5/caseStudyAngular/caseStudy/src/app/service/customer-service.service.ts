import { Injectable } from '@angular/core';

import {CustomerComponent} from '../customer-all/customer/customer.component';
import {Customer} from '../customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../employee';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  constructor(private  httpClient: HttpClient) { }

  findAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(API_URL + '/customer');
  }
  createCustomer(cus: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(API_URL + '/customer', cus);
  }
  findByIdCustomer(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(API_URL + '/customer/' + id);
  }updateCustomer(id: number, cus1): Observable<Customer> {
    return this.httpClient.put<Customer>(API_URL + '/customer/'+id, cus1);
  }

  // createCustomer(customer: Customer) {
  //   CustomerDAO.customers.push(customer);
  // }
  // updateCustomer(customer: Customer) {
  //   CustomerDAO.customers.push(customer);
  // }
  // getAllCustomer() {
  //   return CustomerDAO.getList();
  // }
  // delete(customers: Customer[], id: number) {
  //  return customers.splice(customers.findIndex( a => a.id === id), 1);
  // }
  // findByID(id: number) {
  //   return CustomerDAO.customers.find((cus) => cus.id == id);
  // }


}
