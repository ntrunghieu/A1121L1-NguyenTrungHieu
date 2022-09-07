import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import validate = WebAssembly.validate;

@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css']
})
export class FormRegisterComponent implements OnInit {
  registerForm: FormGroup;

  constructor() {
    this.registerForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      passwordGroup: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        passwordConfirm: new FormControl('', [Validators.required, Validators.minLength(6)])
      }, [ this.comparePassword]) ,
      gender: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      phone: new FormControl('', [Validators.pattern(/^(\+84)\d{9,10}$/)]),
      email: new FormControl('', [Validators.email]),
      country: new FormControl('', [Validators.required])
    });
  }

  ngOnInit(): void {
  }
  comparePassword(c: AbstractControl) {

    const v = c.value;

    if (v.password !== v.passwordConfirm) {
      return {invalid1: true};
    } else {
      return null;
    }
  }
  onSubmit() {
    console.log(this.registerForm.value);
  }
}
