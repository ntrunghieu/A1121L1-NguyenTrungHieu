import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ImportManagerComponent} from './import-manager/import-manager.component';
import {ImportMaterialFormComponent} from './import-manager/import-material-form/import-material-form.component';
import {ImportMaterialCustomerFormComponent} from './import-manager/import-material-customer-form/import-material-customer-form.component';


const routes: Routes = [
  {path: '', component: ImportManagerComponent},
  {path: 'import-material', component: ImportMaterialFormComponent},
  {path: 'import-material-customer', component: ImportMaterialCustomerFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImportRoutingModule {
}
