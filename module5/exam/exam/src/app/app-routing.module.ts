import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
// import {DanhsachComponent} from "./benhnhan/danhsach/danhsach.component";
// import {TaomoiComponent} from "./benhnhan/taomoi/taomoi.component";
// import {ChinhsuaComponent} from "./benhnhan/chinhsua/chinhsua.component";

import {TaosanphamComponent} from "./sanpham/taosanpham/taosanpham.component";

import {TaolohangComponent} from "./lohang/taolohang/taolohang.component";
import {SualohangComponent} from "./lohang/sualohang/sualohang.component";
import {LohanglistComponent} from "./lohang/lohanglist/lohanglist.component";
import {DanhsachsanphamComponent} from "./sanpham/danhsachsanpham/danhsachsanpham.component";
import {ChinhsuasanphamComponent} from "./sanpham/chinhsuasanpham/chinhsuasanpham.component";



const routes: Routes = [
  // {path: '', component: DanhsachComponent},
  // {path: 'tao', component: TaomoiComponent},
  // {path: 'chinhsua/:id', component: ChinhsuaComponent},


  {path: 'lohang', component: LohanglistComponent},
  // {path: 'tao', component: TaolohangComponent},
  // {path: 'chinhsua/:id', component: SualohangComponent},


  {path: '', component: DanhsachsanphamComponent},
  {path: 'tao', component: TaosanphamComponent},
  {path: 'chinhsua/:id', component: ChinhsuasanphamComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
