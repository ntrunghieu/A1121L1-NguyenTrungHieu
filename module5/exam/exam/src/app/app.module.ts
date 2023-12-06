import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from "ngx-pagination";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {OrderModule} from "ngx-order-pipe";
import { TaomoiComponent } from './benhnhan/taomoi/taomoi.component';
import { DanhsachComponent } from './benhnhan/danhsach/danhsach.component';
import { ChinhsuaComponent } from './benhnhan/chinhsua/chinhsua.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DanhsachsanphamComponent } from './sanpham/danhsachsanpham/danhsachsanpham.component';
import { TaosanphamComponent } from './sanpham/taosanpham/taosanpham.component';
import { ChinhsuasanphamComponent } from './sanpham/chinhsuasanpham/chinhsuasanpham.component';


import { TaolohangComponent } from './lohang/taolohang/taolohang.component';
import { SualohangComponent } from './lohang/sualohang/sualohang.component';
import {LohanglistComponent} from "./lohang/lohanglist/lohanglist.component";


@NgModule({
  declarations: [
    AppComponent,
    TaomoiComponent,
    DanhsachComponent,
    ChinhsuaComponent,


    TaolohangComponent,
    SualohangComponent,
    LohanglistComponent,


    HeaderComponent,
    FooterComponent,
    NavbarComponent,

    DanhsachsanphamComponent,
    TaosanphamComponent,
    ChinhsuasanphamComponent,

  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule, Ng2SearchPipeModule, OrderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
