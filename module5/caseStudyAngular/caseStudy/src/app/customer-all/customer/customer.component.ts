import {Component, Input, OnInit} from '@angular/core';
import {CustomerServiceService} from '../../service/customer-service.service';

import {Customer} from '../../customer';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  listCustomer: Customer[] = [];

  // temp: Customer = {};
  // customerIdToDelete: number;
  // customerNameToDelete: string;
  // temp = CustomerDAO.temp;
  // customerIdToDelete = CustomerDAO.customerIdToDelete;
  // customerNameToDelete = CustomerDAO.customerNameToDelete;
  customerIdToDelete: number;
  customerNameToDelete: string;

  constructor(private customerService: CustomerServiceService,
              private route: Router) { }
  displayStyle = 'none';
  ngOnInit(): void {
    this.getAll();
    console.log(this.listCustomer.values());
  }

   delete(id: number) {
    // this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
     // @ts-ignore
     // return this.listCustomer = this.customerService.delete(this.listCustomer, id);
     // return this.listCustomer;
     return CustomerDAO.deleteById(id);
  }


  xoa(event: MouseEvent) {

  }

  getAll() {
    this.customerService.findAll().subscribe((data) => {
      this.listCustomer = data;
      // this.totalLength = data.length;
    });
  }

  markHandler(event: number) {
    console.log(event);
  }

  openPopup() {
    this.displayStyle = 'block';
  }

  // deleteStudent(id: number) {
  //   this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
  // }

  closePopup() {
    this.displayStyle = 'none';
  }

  sendCustomerToDelete(id: number, name: string) {
    this.customerIdToDelete = id;
    this.customerNameToDelete = name;
  }

  // backCustomer() {
  //   this.route.navigateByUrl("customer")
  // }
  //
  // backEmploy() {
  //   this.route.navigateByUrl("employee")
  // }
  //
  // backContract() {
  //   this.route.navigateByUrl("contract")
  // }
  //
  // backService() {
  //   this.route.navigateByUrl("")
  // }
}
