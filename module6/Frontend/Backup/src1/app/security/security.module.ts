import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SecurityRoutingModule } from './security-routing.module';
import { LoginComponent } from './login/login.component';


@NgModule({
    declarations: [LoginComponent],
    exports: [
        LoginComponent
    ],
    imports: [
        CommonModule,
        SecurityRoutingModule
    ]
})
export class SecurityModule { }
