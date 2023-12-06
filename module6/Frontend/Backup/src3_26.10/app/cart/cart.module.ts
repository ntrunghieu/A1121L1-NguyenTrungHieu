import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CartRoutingModule} from './cart-routing.module';
import {DetailCartComponent} from './detail-cart/detail-cart.component';
import {SellCartComponent} from './sell-cart/sell-cart.component';
import {SellExportComponent} from './sell-export/sell-export.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NotifierModule} from 'angular-notifier';
import {LoadingBarRouterModule} from '@ngx-loading-bar/router';
import {LoadingBarModule} from '@ngx-loading-bar/core';


@NgModule({
  declarations: [DetailCartComponent, SellCartComponent, SellExportComponent],
  exports: [
    SellCartComponent
  ],
  imports: [
    CommonModule,
    CartRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NotifierModule,
    LoadingBarRouterModule,
    LoadingBarModule
  ]
})
export class CartModule {
}
