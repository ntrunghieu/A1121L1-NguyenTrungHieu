import {Component, Inject, OnInit} from '@angular/core';
import {CustomerServiceService} from '../../service/customer/customer-service.service';
import {CustomerTypeService} from '../../service/customer/customer-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ICustomerType} from '../../model/customer/icustomer-type';
import {formatDate} from '@angular/common';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';
import {NotifierService} from 'angular-notifier';

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
              private notification: NotifierService,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) {
  }

  customerTypes: ICustomerType[];
  form: FormGroup;
  customerId = 0;
  setAvatar = 0;
  selectedImage: any;
  // url: any;
  upLoadImage = null;
  oldAvatarLink: string;
  url: any;
  validationMessages = {
    customerName: [
      {type: 'required', message: 'Tên không được để trống'},
      {type: 'pattern', message: 'Tên không đúng định dạng'}
    ],
    customerCode: [
      {type: 'required', message: 'Mã khách hàng không được để trống'},
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
      {type: 'pattern', message: 'Số điện thoại không đúng định dạng'}
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
      // , Validators.required
      customerName: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]),
      // , Validators.required
      // [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]
      customerCode: new FormControl('', [Validators.required, Validators.pattern('^MKH-\\d{3}$')]),
      // /, Validators.required
      // , [Validators.required, Validators.pattern('^MKH-\\d{3}$')]
      // customerAvatar: new FormControl('', Validators.required),
      customerAvatar: new FormControl(''),
      // , Validators.required
      customerAddress: new FormControl('', Validators.required),
      // , Validators.required
      customerPhone: new FormControl('', [Validators.required, Validators.pattern('^(03|05|07|09)\\d{8,10}$')]),
      // , Validators.required
      customerEmail: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9]+@gmail.com$')]),
      // , Validators.required
      // , [Validators.required, Validators.pattern('^[a-zA-Z0-9]+@gmail.com$')]
      customerTypeId: new FormControl('', Validators.required),
      // , Validators.required
    });
    // [Validators.required, Validators.pattern('^(03|05|07|09)\\d{8,10}$')])
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

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
  }

  submit() {
    console.log(1);
    if (this.form.valid) {
      console.log(2);
      if (this.customerId === 0) {
        console.log(3);
        const avatarName = this.getCurrentDateTime() + this.upLoadImage.name;
        const fileRef = this.storage.ref(avatarName);
        this.storage.upload(avatarName, this.upLoadImage).snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe(url => {
              this.form.patchValue({customerAvatar: url});

              // //delete old img from firebase
              // this.storage.storage.refFromURL(this.oldAvatarLink).delete();

              // Update employee
              console.log(this.form.value);
              this.customerService.create(this.form.value).subscribe(
                () => {
                },
                (error) => {
                  if (error.status === 500) {
                    this.router.navigateByUrl('/auth/access-denied');
                  }
                },
                () => {
                  this.notification.notify('success', 'Thêm mới khách hàng thành công');
                  this.upLoadImage = null;
                },
              );
            });
          })
        ).subscribe();
        // const nameImg = this.getCurrentDateTime() + this.selectedImage;
        // console.log(nameImg);
        // const fileRef = this.storage.ref(nameImg);
        // this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
        //   finalize(() => {
        //     fileRef.getDownloadURL().subscribe((url) => {
        //       this.form.patchValue({customerAvatar: url});
        // this.customerService.create(this.form.value).subscribe(
        //   () => {
        //   },
        //   (error) => {
        //     if (error.status === 500) {
        //       this.router.navigateByUrl('/auth/access-denied');
        //     }
        //   },
        //   () => {
        //     alert('thêm mới khách hàng');
        //     this.router.navigateByUrl('customer/list');
        //   }
        // );
        //
        //     });
        //   })
        // ).subscribe();
      } else {
        const avatarNameUpdate = this.getCurrentDateTime() + this.upLoadImage.name;
        const fileRef = this.storage.ref(avatarNameUpdate);
        this.storage.upload(avatarNameUpdate, this.upLoadImage).snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe(url => {
              this.form.patchValue({customerAvatar: url});

              // //delete old img from firebase
              // this.storage.storage.refFromURL(this.oldAvatarLink).delete();

              // Update employee
              console.log(this.form.value);
              this.customerService.update(this.form.value).subscribe(
                () => {
                },
                (error) => {
                  if (error.status === 500) {
                    this.router.navigateByUrl('/auth/access-denied');
                  }
                },
                () => {
                  this.notification.notify('success', 'Cập Nhật khách hàng thành công');
                  this.upLoadImage = null;
                },
              );
            });
          })
        ).subscribe();
        //   this.customerService.update(this.form.value).subscribe(
        //     () => {
        //     },
        //     (error) => {
        //       if (error.status === 500) {
        //         this.router.navigateByUrl('/auth/access-denied');
        //       }
        //     },
        //     () => {
        //       alert('update khách hàng');
        //       this.router.navigateByUrl('customer/list');
        //     }
        //   );
        // }
      }
    }
  }


  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

  onSelectFile(e) {
    this.setAvatar =  1;
    this.upLoadImage = e.target.files[0];
    if (e.target.files) {
      const reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        this.url = event.target.result;
        // this.form.controls.customerAvatar = event.target.result;
      };
    }
    console.log(this.url);
    // this.url = e.target.files[0];
  }
}
