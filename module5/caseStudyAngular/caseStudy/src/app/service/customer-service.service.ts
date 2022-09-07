import { Injectable } from '@angular/core';
import {Customer} from '../customer';
import {CustomerComponent} from '../customer-all/customer/customer.component';
import {CustomerDAO} from '../data/CustomerDAO';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  constructor() { }

  createCustomer(customer: Customer) {
    CustomerDAO.customers.push(customer);
  }
  getAllCustomer() {
    return CustomerDAO.getList();
  }
  delete(customers: Customer[], id: number) {
   return customers.splice(customers.findIndex( a => a.id === id), 1);
  }
  findByID(id: number) {
    return CustomerDAO.customers.find((cus) => cus.id == id);
  }


}
