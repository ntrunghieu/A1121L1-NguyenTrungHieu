import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  @Input()
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
  temp: Customer = {};
  customerIdToDelete: number;
  customerNameToDelete: string;
  constructor() { }
  displayStyle = 'none';
  ngOnInit(): void {
  }

  delete(id: number) {
    this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
  }


  xoa(event: MouseEvent) {

  }

  getInfor(cus: Customer) {
    return this.temp = cus;
  }
  getList() {
    return this.customers;
  }

  markHandler(event: number) {
    console.log(event);
  }

  openPopup() {
    this.displayStyle = 'block';
  }

  deleteStudent(id: number) {
    this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
  }

  closePopup() {
    this.displayStyle = 'none';
  }

  sendCustomerToDelete(id: number, name: string) {
    this.customerIdToDelete = id;
    this.customerNameToDelete = name;
  }
}
