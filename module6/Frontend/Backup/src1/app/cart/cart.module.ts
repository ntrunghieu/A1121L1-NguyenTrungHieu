import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CartRoutingModule } from './cart-routing.module';
import { DetailCartComponent } from './detail-cart/detail-cart.component';
import { SellCartComponent } from './sell-cart/sell-cart.component';
import { SellExportComponent } from './sell-export/sell-export.component';


@NgModule({
  declarations: [DetailCartComponent, SellCartComponent, SellExportComponent],
  imports: [
    CommonModule,
    CartRoutingModule
  ]
})
export class CartModule { }
