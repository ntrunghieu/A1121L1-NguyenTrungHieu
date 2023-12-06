import {Component, Inject, OnInit} from '@angular/core';
import {CustomerServiceService} from '../../../service/customer/customer-service.service';
import {CustomerTypeService} from '../../../service/customer/customer-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ICustomerType} from '../../../model/customer/icustomer-type';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {AngularFireStorage} from '@angular/fire/storage';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  constructor(private customerService: CustomerServiceService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) {
  }

  customerTypes: ICustomerType[];
  form: FormGroup;
  customerId = 0;
  selectedImage: any;
  url: any;
  validationMessages = {
    customerName: [
      {type: 'required', message: 'Tên không được để trống'},
      {type: 'pattern', message: 'Tên không đúng định dạng'}
    ],
    customerCode: [
      {type: 'required', message: 'Code không được để trống'},
      {type: 'pattern', message: 'Mã khách hàng không đúng định dạng'}
    ],
    customerAvatar: [
      {type: 'required', message: 'Avatar không được để trống'},
      // {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    customerId: [
      {type: 'required', message: 'Mã Khách Hàng không được để trống'},
      {type: 'pattern', message: 'Tên không chứa kí tự đặc biệt'}
    ],
    customerAddress: [
      {type: 'required', message: 'Địa chỉ không được để trống'},
      {type: 'pattern', message: 'Địa chỉ không chứa kí tự đặc biệt'}
    ],
    customerPhone: [
      {type: 'required', message: 'Số điện thoại không được để trống'},
      {type: 'checkBirthday', message: 'Số điện thoại không đúng định dạng'}
    ],
    customerEmail: [
      {type: 'required', message: 'Email không được để trống'},
      {type: 'pattern', message: 'Email định dạng abc@gmail.com'}
    ],
    customerTypeId: [
      {type: 'required', message: 'Số Điện Thoại không được để trống'},
      {type: 'pattern', message: 'Số điện thoại dạng 10-12 số'}
    ],
  };

  ngOnInit(): void {
    this.customerTypeService.getAll().subscribe(customerTypes => this.customerTypes = customerTypes);
    this.form = new FormGroup({
      customerId: new FormControl(''),
      customerName: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]),
      customerCode: new FormControl('', [Validators.required, Validators.pattern('^MKH-\\d{3}$')]),
      customerAvatar: new FormControl('', Validators.required),
      customerAddress: new FormControl('', Validators.required),
      customerPhone: new FormControl('', [Validators.required, Validators.pattern('^(03|05|07|09)\\d{8,10}$')]),
      customerEmail: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9]+@gmail.com$')]),
      customerTypeId: new FormControl('', Validators.required),
    });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const customerId = paramMap.get('id');
      console.log(customerId);
      if (customerId !== null) {
        this.customerId = Number(customerId);
        this.customerService.findCustomerById(this.customerId).subscribe(customer => {
          this.form.patchValue(customer);
          this.url = customer.customerAvatar;
        });
      }
    });
  }

  compare(o1: any, o2: any) {
    if (o1 === null || o2 === null) {
      return false;
    }
    return o1.id === o2.id;
  }

  submit() {
    console.log(1);
    if (this.form.valid) {
      console.log(2);
      if (this.customerId === 0) {
        console.log(3);
        const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
        const fileRef = this.storage.ref(nameImg);
        this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe((url) => {
              this.form.patchValue({customerAvatar: url});
              this.customerService.create(this.form.value).subscribe(
                next => {
                  alert('thanh công');
                  this.router.navigateByUrl('/customer');
                }
              );
            });
          })
        ).subscribe();
      } else {
        console.log(3);
        this.customerService.update(this.form.value).subscribe(
          next => {
            console.log(this.form.value);
            this.router.navigateByUrl('/customer');
          }
        );
      }
    }
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

  onSelectFile(e) {
    if (e.target.files) {
      const reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        this.url = event.target.result;
      };
    }
    console.log(this.url);
    // this.url = e.target.files[0];
  }
}
