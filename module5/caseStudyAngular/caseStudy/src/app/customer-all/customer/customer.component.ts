import {Component, Input, OnInit} from '@angular/core';
import {CustomerServiceService} from '../../service/customer-service.service';

import {Customer} from '../../customer';
import {Router} from '@angular/router';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  searchForm: FormGroup;
  name: any;
   page: number = 0;


  // indexPagination: number = 0;
  // totalPagination: number;
   totalPagination: Array<number>;
  // totalLength: number;
  // page: number = 1;
  customers: Customer[] = [];
  listCustomer: Customer[] = [];
  listCustomerNotPagination: Customer[] = [];
  customer: Customer = {
    customerType:{}
  };


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

  setPage(i,event: any) {
    event.preventDefault();
    this.page=i;
    this.getAll();
  }
  ngOnInit(): void {
   this.getAll();

    // this.customerService.getAllCustomerNotPagination().subscribe((data: Customer[]) => {
    //
    //   this.listCustomerNotPagination = data;
    //
    //   if ((this.listCustomerNotPagination.length % 5) != 0) {
    //     this.totalPagination = (Math.round(this.listCustomerNotPagination.length / 5)) + 1;
    //   }
    // })
    // this.getAll();
  }

   delete(id: number) {
    // this.customers.splice(this.customers.findIndex( a => a.id === id), 1);
     // @ts-ignore
     // return this.listCustomer = this.customerService.delete(this.listCustomer, id);
     // return this.listCustomer;
     // return CustomerDAO.deleteById(id);
     this.customerService.delete(this.customerIdToDelete).subscribe(
       () => {},
       () => {},
       () => {
         this.getAll()
       }
     )
     this.customerService.findByIdCustomer(this.customer.customerId).subscribe(
       (data) => {
         this.customer=data;
       }
     )


  }


  getAll() {

    this.customerService.getAllCustomer(this.page).subscribe((data) => {
      this.listCustomer = data['content'];
      // this.indexPagination = 0;
      this.totalPagination = new Array(data['totalPages']);
      console.log(data['totalPages']);

    });


    // this.customerService.findAll().subscribe((data) => {
    //   this.listCustomer = data;
    //   // this.totalLength = data.length;
    // });
  }


  sendCustomerToDetail(cus:Customer) {
    this.customer=cus;
    // this.customerIdToDelete = id;
    // this.customerNameToDelete = name;
  }
  sendCustomerToDelete(id: number, name:string) {

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
  search() {
    if (this.name==""){
      this.ngOnInit();
    }else {
      this.customerService.searchName(this.name).subscribe((data) => {
        this.listCustomer = data;
        console.log(this.customers);
      });

    }
  }

  firtPage() {
    // this.indexPagination = 1;
    // this.ngOnInit();
  }

  previousPage() {
    // this.indexPagination = this.indexPagination - 1;
    // if (this.indexPagination == 0) {
    //   this.indexPagination = 1;
    //   this.ngOnInit();
    // } else {
    //   this.customerService.getAllCustomer((this.indexPagination * 5) - 5).subscribe((data: Customer[]) => {
    //     this.listCustomer = data['content'];
    //   })
    // }
  }

  indexPaginationChage(value: number) {
    // this.indexPagination = value;
  }

  findPaginnation() {
    // this.customerService.getAllCustomer((this.indexPagination * 5) - 5).subscribe((data) => {
    //   this.listCustomer = data['content'];
    // })
  }

  nextPage() {
    // this.indexPagination = this.indexPagination + 1;
    // if (this.indexPagination > this.totalPagination) {
    //   this.indexPagination = this.indexPagination - 1;
    // }
    // this.customerService.getAllCustomer((this.indexPagination * 5) - 4).subscribe((data) => {
    //   this.listCustomer = data['content'];
    // })
  }

  lastPage() {
    // this.indexPagination = this.listCustomerNotPagination.length / 5;
    // this.customerService.getAllCustomer((this.indexPagination * 5) - 5).subscribe((data: Customer[]) => {
    //   this.listCustomer = data['content'];
    // })
  }
}
