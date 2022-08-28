import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor() { }
  customers: Customer[] = [
    {
      id: 1,
      name: 'hieu',
      idCard: '2134',
      phone: '1234',
      email: 'hieu@gmail.com',
      gender: true,
      address: 'aasd',
      type: 'asd'
    },
    {
      id: 2,
      name: 'hung',
      idCard: '2134',
      phone: '1234',
      email: 'hung@gmail.com',
      gender: false,
      address: 'son tra',
      type: 'vjp pro'
    }
];
  ngOnInit(): void {
  }

  delete(id: number) {
    this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
  }
}
