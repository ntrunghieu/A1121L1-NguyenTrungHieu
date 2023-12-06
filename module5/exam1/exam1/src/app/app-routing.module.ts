import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DanhsachsanphamComponent} from './sanpham/danhsachsanpham/danhsachsanpham.component';
import {TaosanphamComponent} from './sanpham/taosanpham/taosanpham.component';
import {DanhsachdetaiComponent} from './detai/danhsachdetai/danhsachdetai.component';
import {TaodetaiComponent} from './detai/taodetai/taodetai.component';
import {SuadetaiComponent} from './detai/suadetai/suadetai.component';


const routes: Routes = [
  // {path: '', component: DanhsachsanphamComponent},
  // {path: 'tao', component: TaosanphamComponent},
  // {path: 'chinhsua/:id', component: ChinhsuasanphamComponent}

  {path: '', component: DanhsachdetaiComponent},
  {path: 'tao', component: TaodetaiComponent},
  {path: 'chinhsua/:id', component: SuadetaiComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
