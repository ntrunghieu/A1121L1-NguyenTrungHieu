import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {CartServiceService} from '../../service/cart/cart-service.service';
import {ICartMaterial} from '../../model/cart/icart-material';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ICustomer} from '../../model/customer/icustomer';
import {HttpErrorResponse} from '@angular/common/http';
import {ProvinceCity} from '../../model/cart/provinceCity';
import {Wards} from '../../model/cart/wards';
import {NotifierService} from 'angular-notifier';
import {Router} from '@angular/router';
import {IMaterial} from '../../model/material/imaterial';
import {LoadingBarService} from '@ngx-loading-bar/core';

@Component({
  selector: 'app-detail-cart',
  templateUrl: './detail-cart.component.html',
  styleUrls: ['./detail-cart.component.css']
})
export class DetailCartComponent implements OnInit {
  @ViewChild('closeBtn') closeBtn: ElementRef;
  cartList: ICartMaterial[] = [];
  totalMoney = 0;
  listDelete: number[] = [];
  listPayment: number[] = [];
  listCartPayment: ICartMaterial[] = [];
  deleteCart: ICartMaterial;
  formCreate: FormGroup;
  apiListProvinceCity: ProvinceCity[] = [];
  provinceCity: ProvinceCity = undefined;
  wards: Wards ;
  text = '';
  textProvinceCity = '';
  textDistrict = '';
  textWards = '';
  textSpecificAddress = '';
  customerErr: ICustomer;
  checkValidate = false;
  // tslint:disable-next-line:max-line-length
  constructor(private cartService: CartServiceService, private fb: FormBuilder, private notifier: NotifierService, private router: Router, private loadingBar: LoadingBarService) { }

  ngOnInit(): void {
    this.getListCart();
    // this.checkCartPayment();
    this.formCreate = this.fb.group(
      {
        // tslint:disable-next-line:max-line-length
        customerName: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(50)]],
        customerPhone: ['', [ Validators.required, Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]],
        customerEmail: ['', [Validators.email, Validators.required, Validators.minLength(6), Validators.maxLength(50)]],
        customerAddress: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(255)]],
      }
    );
    this.getAllProvinceCity();
  }
  getListCart() {
    this.totalMoney = 0;
    this.cartService.getAllCart().subscribe(data => {
      this.cartList = data;
      console.log(data);
    });
  }
  getAllProvinceCity(): void {
    this.cartService.getAllProvinceCity().subscribe(
      data => {
        this.apiListProvinceCity = data;
        console.log(data);
      },
      (error: HttpErrorResponse) => {
        console.log(error);
      }
    );
  }
  subtraction(cart: ICartMaterial) {
    if (cart.cartId.cartQuantity === 1) {
      this.deleteCart = cart;
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      button.setAttribute('data-target', '#deleteCartModal');
      container.appendChild(button);
      button.click();
    } else {
      cart.cartId.cartQuantity = cart.cartId.cartQuantity - 1;
      cart.cartId.cartTotalMoney = cart.cartId.cartQuantity * cart.materialId.materialPrice;
      this.cartService.updateQuantity(cart.cartId.cartQuantity, cart.cartId.cartTotalMoney, cart.cartId.cartId).subscribe(data => {
        this.checkCartPayment();
      });
    }
  }
  sum(cart: ICartMaterial) {
    cart.cartId.cartQuantity = cart.cartId.cartQuantity + 1;
    cart.cartId.cartTotalMoney =  cart.cartId.cartQuantity * cart.materialId.materialPrice;
    this.cartService.updateQuantity( cart.cartId.cartQuantity, cart.cartId.cartTotalMoney, cart.cartId.cartId).subscribe(data => {
      this.checkCartPayment();
    });
  }

  deleteCartByFlag(cartMaterialId: number) {
    this.cartService.deleteCart(cartMaterialId).subscribe(data => {
      this.getListCart();
    });

  }

  insertCart() {
    const selectedProducts = this.cartList.filter(cart => cart.checked).map(p => p.cartMaterialId);
    this.listDelete = selectedProducts;
    if (selectedProducts && selectedProducts.length > 0) {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      button.setAttribute('data-target', '#addCustomerModal');
      container.appendChild(button);
      button.click();
    } else  {
      this.notifier.notify('default', 'Vui lòng chọn sản phẩm');
    }
  }

  onInsertCart(formCreate: FormGroup): void {
    this.startLoading();
    this.checkValidate = false;
    this.cartService.insertCart(formCreate.value, this.listPayment).subscribe(
       (data: void) => {
         this.stopLoading();
         this.cartService.getPdf(this.listPayment).subscribe(x => {
           const blob = new Blob([x], {type: 'application/pdf'});
           if (window.navigator && window.navigator.msSaveOrOpenBlob) {
             window.navigator.msSaveOrOpenBlob(blob);
             return;
           }
           const data1 = window.URL.createObjectURL(blob);
           const link = document.createElement('a');
           link.href = data1;
           link.download = 'invoice.pdf';
           link.dispatchEvent(new MouseEvent('click' , {bubbles: true, cancelable: true, view: window}));
           // tslint:disable-next-line:only-arrow-functions
           setTimeout(function() {
             window.URL.revokeObjectURL(data1);
             link.remove();
           }, 100);
         });
         this.closeModal();
         this.notifier.notify('success', 'Thanh toán thành công');
         this.resetForm();
         this.listCartPayment = [];
         this.provinceCity = null;
         this.wards = null;
         this.ngOnInit();
       },
       // (error: HttpErrorResponse) => {
       //   this.customerErr = error.error;
       // }
      (error) => {
        if (error.status === 400) {
          this.customerErr = error.error;
        }
        if (error.status === 500) {
          this.router.navigateByUrl('/auth/access-denied');
        }
      }
     );
  }

  resetForm() {
    this.formCreate = this.fb.group(
      {
        // tslint:disable-next-line:max-line-length
        customerName: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(50)]],
        customerPhone: ['', [ Validators.required, Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]],
        customerEmail: ['', [Validators.email, Validators.required, Validators.minLength(6), Validators.maxLength(50)]],
        customerAddress: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(255)]],
      }
    );
    this.checkValidate = true;
    this.getAllProvinceCity();
  }
  addTextProvinceCity(value: any) {
    if (value !== '0') {
      this.cartService.getProvinceCity(value).subscribe(
        data => {
          this.provinceCity = data.districts;
          this.textProvinceCity = data.name + ', ';
          this.text = this.textProvinceCity;
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      );
      this.wards = null;
    } else {
      this.text = '' ;
      this.provinceCity = null;
      this.wards = null;
    }
  }

  addTextDistrict(value: any) {
    if (value !== '0') {
      this.cartService.getDistrict(value).subscribe(
        data => {
          if (this.textDistrict !== '' ||  this.textWards !== '') {
            this.textDistrict = '';
            this.text = this.textProvinceCity ;
          }
          this.wards = data.wards;
          this.textDistrict = data.name + ', ';
          this.text = this.text + this.textDistrict ;
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      );
    } else {
      this.wards = null;
    }
  }

  addTextWards(value: any) {
    if (this.textWards !== '') {
      this.text = this.textProvinceCity + this.textDistrict ;
    }
    this.cartService.getWards(value).subscribe(data => {
      this.textWards = data.name;
      this.text = this.text + this.textWards + ',';
      // }
    });
  }

  resetText(value: any) {
    if (value === '') {
      this.provinceCity = null;
      this.wards = null;
      this.cartService.getAllProvinceCity().subscribe(
        data => {
          this.apiListProvinceCity = data;
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      );
      this.text = '';
      this.textSpecificAddress = '';
    }
  }

  deleteAllCart(): void {
    const selectedProducts = this.cartList.filter(cart => cart.checked).map(p => p.cartMaterialId);
    this.listDelete = selectedProducts;
    if (selectedProducts && selectedProducts.length > 0) {
      this.cartService.deleteCart2(this.listDelete)
        .subscribe(data => {
            this.listCartPayment = [];
            this.ngOnInit();
          }, err => {
            console.log(err);
          }
        );
    }
  }

  checkCartDelete(): void {
    const selectedProducts = this.cartList.filter(cart => cart.checked).map(p => p.cartMaterialId);
    this.listDelete = selectedProducts;
    if (selectedProducts && selectedProducts.length > 0) {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      button.setAttribute('data-target', '#deleteCartModal1');
      container.appendChild(button);
      button.click();
    } else  {
      this.notifier.notify('default', 'Vui lòng chọn sản phẩm');
    }
  }
  checkAllCheckBox(ev: any) {
    this.cartList.forEach(x => x.checked = ev.target.checked);
    this.checkCartPayment();
  }

  isAllCheckBoxChecked() {
    if (this.cartList !== null) {
      return this.cartList.every(p => p.checked);
    }
  }

  checkCartPayment(): void {
    const selectedProducts = this.cartList.filter(cart => cart.checked).map(p => p.cartMaterialId);
    this.listPayment = selectedProducts;
    if (selectedProducts && selectedProducts.length > 0 ) {
      this.cartService.checkCartPayment(this.listPayment)
        .subscribe(data => {
          this.listCartPayment = data;
          this.totalMoney = 0;
          if (this.listPayment !== null) {
            // tslint:disable-next-line:prefer-for-of
            for (let i = 0 ; i < this.listCartPayment.length; i++) {
              if (this.listCartPayment[i] !== null) {
                this.totalMoney = this.totalMoney + this.listCartPayment[i].cartId?.cartTotalMoney;
              }
            }
          }
          }, err => {
            console.log(err);
          }
        );
    } else {
      this.listCartPayment = [];
      this.ngOnInit();
    }
  }
  private closeModal(): void {
    this.closeBtn.nativeElement.click();
  }



  startLoading() {
    this.loadingBar.start();
  }

  stopLoading() {
    this.loadingBar.complete();
  }
}
