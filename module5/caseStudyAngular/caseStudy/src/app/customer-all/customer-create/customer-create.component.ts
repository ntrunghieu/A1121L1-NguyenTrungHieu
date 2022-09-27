import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerServiceService} from '../../service/customer-service.service';
import {Route, Router} from '@angular/router';
import {TypeCustomer} from '../../type-customer';
import {TypeCustomerService} from '../../service/type-customer.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  createForm: FormGroup;
  typeCustomer: TypeCustomer[] = [];
  constructor(private customerService: CustomerServiceService,
              private typeCustomerService: TypeCustomerService,
              private route: Router) {
  }

  ngOnInit(): void {
    this.createForm = new FormGroup({
      // id: new FormControl('', [Validators.required, Validators.pattern(/^[K]{1}[H]{1}[-]{1}[0-9]{4}$/)]),
      customerId: new FormControl(''),
      customerName: new FormControl('', [Validators.required]),
      customerBirthday: new FormControl('', [Validators.required]),
      customerIdCard: new FormControl('',[Validators.required, Validators.pattern(/^([0-9]{9})|([0-9]{12})$/)]),
      customerGender: new FormControl('', [Validators.required]),
      customerType: new FormControl('', [Validators.required]),
      customerPhone: new FormControl('', [Validators.required, Validators.pattern(/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/)]),
      customerEmail: new FormControl('', [Validators.required, Validators.pattern(/^[a-z][a-z0-9_.]{0,32}@[a-z0-9]{2,}(.[a-z0-9]{2,4}){1,2}$/)]),
      customerAddress: new FormControl('', [Validators.required])
    });
    this.getTypeCustomer();
  }

  onSubmit() {
    this.customerService.createCustomer(this.createForm.value).subscribe(data => {
      console.log(data);
      alert('Ban da them moi khach hang ' + this.createForm.value.customerName);
      this.route.navigateByUrl('/customer');
    }, () => {
      console.log('error');
    });
    // this.customerService.createCustomer(this.createForm.value);
    // this.route.navigateByUrl("customer");
  }

  back() {
    this.route.navigateByUrl("customer");
  }
  getTypeCustomer() {
    this.typeCustomerService.findAll().subscribe((data) => {
      this.typeCustomer = data;
    });
  }
}

