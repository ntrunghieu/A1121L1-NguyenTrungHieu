import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../../customer';
import {CustomerServiceService} from '../../service/customer-service.service';
import {CustomerDAO} from '../../data/CustomerDAO';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  listCustomer: Customer[] = [];
  // @Input()
  // public customers: Customer[] = [
  //   {
  //     id: 1,
  //     name: 'hieu',
  //     idCard: '2134',
  //     phone: '1234',
  //     email: 'hieu@gmail.com',
  //     gender: true,
  //     address: 'aasd',
  //     type: 'asd'
  //   },
  //   {
  //     id: 2,
  //     name: 'hung',
  //     idCard: '2134',
  //     phone: '1234',
  //     email: 'hung@gmail.com',
  //     gender: false,
  //     address: 'son tra',
  //     type: 'vjp pro'
  //   }
  // ];
  // temp: Customer = {};
  // customerIdToDelete: number;
  // customerNameToDelete: string;
  temp = CustomerDAO.temp;
  customerIdToDelete = CustomerDAO.customerIdToDelete;
  customerNameToDelete = CustomerDAO.customerNameToDelete;
  constructor(private customerService: CustomerServiceService) { }
  displayStyle = 'none';
  ngOnInit(): void {
    this.listCustomer = this.customerService.getAllCustomer();
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

  getInfor(cus: Customer) {
    return CustomerDAO.getInfor(cus);
  }
  // getList() {
  //   return this.customers;
  // }

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
    // return  CustomerDAO.sendCustomerToDelete(id, name);
    // this.customerIdToDelete = id;
    // this.customerNameToDelete = name;
  }
}
