import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ICustomer} from '../../model/customer/icustomer';
import {CustomerServiceService} from '../../service/customer/customer-service.service';
import {NotifierService} from 'angular-notifier';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  listCustomer: ICustomer[] = [];
  listDeleteCustomer: number[] = [];
  mang = '';
  mangString: Array<string> = [];
  listCustomerNotPagination: ICustomer[] = [];
  totalPagination: Array<any>;
  page = 1;
  size: number;
  totalItems: number;
  pageCurrent: any;
  indexCurrent: any;
  name: any;
  id: any;
  searchNameAndPhoneForm: FormGroup;
  hidden = 1;
  message = '';

  constructor(private customerService: CustomerServiceService,
              private router: Router,
              private notification: NotifierService ) { }
    // HieuNT setPage for pagination
  setPage(i, event: any) {
    event.preventDefault();
    this.page = i * 5;

    this.getAllCustomerWithPagination();
  }
  ngOnInit(): void {
    // this.getAllCustomer();
    this.getCustomerList(this.page);

    // this.mangString =  this.mang.split(' ' );
    // console.log(this.mangString);
    // this.getAllCustomerWithPagination();
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
          this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / 5)  )  );
          this.totalItems = this.listCustomerNotPagination.length;
          console.log('total items' + this.totalItems);
        } else {
          this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / 5) + 1 )  );
          this.totalItems = this.listCustomerNotPagination.length;
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
        // alert('Xóa khách hàng ' + this.name + ' thành công');
        this.notification.notify('success', 'Xoá khách hàng thành công');
        // this.getAllCustomerWithPagination();
          this.getCustomerList(this.page);
      }
    );
  }

  sendCustomerToDelete(customerId: number, customerName: string) {
    this.name = customerName;
    this.id = customerId;
  }

  send() {
    if (this.searchNameAndPhoneForm.get('name').value == '' && this.searchNameAndPhoneForm.get('phone').value == '') {
      // this.page = 0;
      this.message = '';
      // this.getAllCustomerWithPagination();
      // this.totalPagination = new Array((Math.round(this.listCustomerNotPagination.length / 5) )  );
      // this.totalItems = this.listCustomerNotPagination.length;
      this.getCustomerList(0);
    } else {
      this.customerService.searchCustomerByNameAndPhone(this.searchNameAndPhoneForm.get('name').value,
        this.searchNameAndPhoneForm.get('phone').value, 0).subscribe(
        (data: any) => {
          this.listCustomer = data.content;
          this.size = data.size;
          this.totalItems = data.totalElements;
          this.message = '';
          this.totalItems = 1;
          console.log('total items: ' + this.totalItems);
        },
        (error) => {
          if (error.status === 500) {
            this.router.navigateByUrl('/auth/access-denied');
          }
        },
        () => {
            console.log('total items: ' + this.totalItems);
          if (this.totalItems == 0) {
            // this.page = 0;
              console.log('khi length la 0 ');
              this.message = 'Khách hàng đã xóa hoặc không tồn tại';
            // this.getAllCustomer();
            // this.getAllCustomerWithPagination();
              this.getCustomerList(0);
          }
        });
    }
  }

    getCustomerList(page: number) {
        this.page = page;
        this.customerService.findAllCustomer(this.page - 1).subscribe((data: any) => {
                this.listCustomer = data.content;
                this.size = data.size;
                this.totalItems = data.totalElements;
                console.log(this.totalItems);
            },
            () => {
                this.page--;
                this.getCustomerList(this.page);
            }
        );
    }
}
