import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerServiceService} from '../../service/customer-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../../customer';
import {TypeCustomerService} from '../../service/type-customer.service';
import {TypeCustomer} from '../../type-customer';

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {
  id: number;
  updateForm: FormGroup;
  cus: Customer | undefined;
  typeCustomer: TypeCustomer[] = [];
  constructor(private customerService: CustomerServiceService,
              private type: TypeCustomerService,
              private route: Router,
              private activedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activedRouter.snapshot.params.id;
    this.customerService.findByIdCustomer(this.id).subscribe(
      data => {
        this.cus = data;
        console.log(this.cus);
      }
    );

    this.updateForm = new FormGroup({
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

    this.activedRouter.paramMap.subscribe((param) => {
      // tslint:disable-next-line:radix
      const id = parseInt(param.get('id'));
      // this.cus = this.customerService.findByID(id);
    });
  }
  onSubmit() {
    console.log(this.updateForm.value);
    this.customerService.updateCustomer(this.id, this.updateForm.value).subscribe(
      data => {
        console.log('success');
        this.route.navigateByUrl('customer');
      }
    );
  }

  back() {
    this.route.navigateByUrl("customer");
  }
  getTypeCustomer() {
    this.type.findAll().subscribe((data) => {
      this.typeCustomer = data;
    });
  }
}
