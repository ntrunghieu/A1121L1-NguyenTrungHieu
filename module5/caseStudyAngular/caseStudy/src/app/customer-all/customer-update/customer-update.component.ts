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
  cus: Customer  | undefined;
  typeCustomer: TypeCustomer[] = [];
  constructor(private customerService: CustomerServiceService,
              private type: TypeCustomerService,
              private route: Router,
              private activedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activedRouter.snapshot.params.id;
    this.customerService.findByIdCustomer(this.id).subscribe(
      (data) => {
        this.updateForm = new FormGroup({
          customerId: new FormControl(data.customerId),
          customerName: new FormControl(data.customerName, [Validators.required]),
          customerBirthday: new FormControl(data.customerBirthday, [Validators.required]),
          customerIdCard: new FormControl(data.customerIdCard, [Validators.required]),
          customerGender: new FormControl(data.customerGender, [Validators.required]),
          customerType: new FormControl(data.customerType, [Validators.required]),
          customerPhone: new FormControl(data.customerPhone, [Validators.required]),
          customerEmail: new FormControl(data.customerEmail, [Validators.email]),
          customerAddress: new FormControl(data.customerAddress, [Validators.required])
        })
        // this.cus = data;

      },
      () => {},
      () => {
        console.log(this.updateForm.value);
      },
    );

    this.updateForm = new FormGroup({
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

    // this.activedRouter.paramMap.subscribe((param) => {
    //   // tslint:disable-next-line:radix
    //   const id = parseInt(param.get('id'));
    //   // this.cus = this.customerService.findByID(id);
    // });
  }
  onSubmit() {
    console.log(this.updateForm.value);
    this.customerService.updateCustomer(this.id, this.updateForm.value).subscribe(
      () => {},
      () => {},
      () => {
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
  compareObjects(o1: any, o2: any) {
    // if(o1.name == o2.name && o1.id == o2.id )
    //   return true;
    // else return false
    return o1 && o2 ? o1.id === o2.id : o1 = o2;
  }
}
