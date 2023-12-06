import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DetailCartComponent} from './detail-cart/detail-cart.component';


const routes: Routes = [
  {
    path: 'cart/detail' , component: DetailCartComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartRoutingModule { }
