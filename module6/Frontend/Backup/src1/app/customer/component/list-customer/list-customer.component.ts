import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ICustomer} from '../../../model/customer/icustomer';
import {CustomerServiceService} from '../../../service/customer/customer-service.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  listCustomer: ICustomer[] = [];
  listCustomerNotPagination: ICustomer[] = [];
  totalPagination: Array<any>;
  page = 0;
  pageCurrent: any;
  indexCurrent: any;
  name: any;
  id: any;
  searchNameAndPhoneForm: FormGroup;
  hidden = 1;
  message = '';

  constructor(private customerService: CustomerServiceService,
              private route: Router) { }
    // HieuNT setPage for pagination
  setPage(i, event: any) {
    event.preventDefault();
    this.page = i * 5;

    this.getAllCustomerWithPagination();
  }
  ngOnInit(): void {
    this.getAllCustomer();
    this.getAllCustomerWithPagination();
    this.searchNameAndPhoneForm = new FormGroup({
      name: new FormControl(''),
      phone: new FormControl('')
    });
  }
  // HieuNT get list customer without pagination
  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(
      (data) => {
        this.listCustomerNotPagination = data;
        console.log(Math.round(this.listCustomerNotPagination.length / 5));
        this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / 5) )  );
        if ((this.listCustomerNotPagination.length % 5) !== 0) {
          this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / 5) + 1 )  );
        } else {
          this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / 5) )  );
        }
      });
  }
  // HieuNT get list customer with pagination
  getAllCustomerWithPagination() {
    this.customerService.getAllCustomerWithPagination(this.page).subscribe(
      (data) => {
        this.listCustomer = data;
      });
  }

  previous(event: any) {
    event.preventDefault();
    console.log(this.page);
    if (this.page <= 0) {
      this.page = 0;
      this.getAllCustomerWithPagination();
    } else {
      this.page = this.page - 5;
    }
    this.customerService.getAllCustomerWithPagination(this.page).subscribe((data: ICustomer[]) => {
      this.listCustomer = data;
    });
  }

  next(event: any) {
    event.preventDefault();
    this.page = this.page + 5;
    if (this.page >= this.totalPagination.length * 5) {
      this.page = this.totalPagination.length * 5 - 5;
      console.log(this.page);
      this.getAllCustomerWithPagination();
    }
    this.getAllCustomerWithPagination();
    // this.customerService.getAllCustomerWithPagination(this.page).subscribe((data: ICustomer[]) => {
    //   this.listCustomer = data;
    // });
  }
  deleteCustomerById(id: number) {
    this.customerService.deleteCustomerById(id).subscribe(
      () => {
        this.getAllCustomer();
      },
      () => {},
      () => {
        alert('Xóa khách hàng ' + this.name + ' thành công');
        this.getAllCustomerWithPagination();
      }
    );
  }

  sendCustomerToDelete(customerId: number, customerName: string) {
    this.name = customerName;
    this.id = customerId;
  }

  send() {
    if (this.searchNameAndPhoneForm.get('name').value == '' && this.searchNameAndPhoneForm.get('phone').value == '') {
      this.page = 0;
      this.getAllCustomerWithPagination();
      this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / 5) )  );
    } else {
      this.customerService.searchCustomerByNameAndPhone(this.searchNameAndPhoneForm.get('name').value,
        this.searchNameAndPhoneForm.get('phone').value ).subscribe(
        (data) => {
          this.listCustomer = data;
          this.message = '';
          this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / this.listCustomerNotPagination.length)  )  );
          console.log(this.totalPagination.length);
        },
        () => {},
        () => {
          if (this.listCustomer.length == 0) {
            this.page = 0;
            this.message = 'Khách hàng đã xóa hoặc không tồn tại';
            this.getAllCustomer();
            this.getAllCustomerWithPagination();
          }
        });
    }
  }


}
