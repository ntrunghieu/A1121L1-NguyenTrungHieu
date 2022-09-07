import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerServiceService} from '../../service/customer-service.service';
import {Route, Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  createForm: FormGroup;

  constructor(private customerService: CustomerServiceService,
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
  }

  onSubmit() {
    this.customerService.createCustomer(this.createForm.value);
    this.route.navigateByUrl('');
  }
}

