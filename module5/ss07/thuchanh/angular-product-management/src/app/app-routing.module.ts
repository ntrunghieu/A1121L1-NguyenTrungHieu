import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductDetailComponent} from './product/product-detail/product-detail.component';
import {DictionaryService} from './service/dictionary.service';
import {DictionaryDetailComponent} from './dictionary/dictionary-detail/dictionary-detail.component';
import {DictionaryListComponent} from './dictionary/dictionary-list/dictionary-list.component';
import {ProductUpdateComponent} from './product/product-update/product-update.component';
import {ProductDeleteComponent} from './product/product-delete/product-delete.component';


const routes: Routes = [
  // {path: '', component: DictionaryListComponent},
  // {path: 'detail/:word', component: DictionaryDetailComponent}
  {path: '', component: ProductListComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product/update/:id', component: ProductUpdateComponent},
  {path: 'product/delete/:id', component: ProductDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
