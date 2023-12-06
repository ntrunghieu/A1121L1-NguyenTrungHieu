import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {OrderModule} from 'ngx-order-pipe';
import { DanhsachsanphamComponent } from './sanpham/danhsachsanpham/danhsachsanpham.component';
import { TaosanphamComponent } from './sanpham/taosanpham/taosanpham.component';
import { DanhsachdetaiComponent } from './detai/danhsachdetai/danhsachdetai.component';
import { TaodetaiComponent } from './detai/taodetai/taodetai.component';
import { SuadetaiComponent } from './detai/suadetai/suadetai.component';

@NgModule({
  declarations: [
    AppComponent,
    DanhsachsanphamComponent,
    TaosanphamComponent,
    DanhsachdetaiComponent,
    TaodetaiComponent,
    SuadetaiComponent
  ],
  imports: [
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
