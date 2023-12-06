import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CreateAccountComponent} from './create-account/create-account.component';
import {ChangePasswordComponent} from './change-password/change-password/change-password.component';

const routes: Routes = [

  {
    path: 'create',
    component: CreateAccountComponent
  },
  {
    path: 'update/password/:id',
    component: ChangePasswordComponent
  }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AccountRoutingModule {
}
