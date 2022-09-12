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
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      date: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      type: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.email]),
      address: new FormControl('', [Validators.required])
    });
    this.getTypeCustomer();
  }

  onSubmit() {
    this.customerService.createCustomer(this.createForm.value).subscribe(data => {
      console.log(data);
      alert('Ban da them moi khach hang ' + this.createForm.value.name);
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

