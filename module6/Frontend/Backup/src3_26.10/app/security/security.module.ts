import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SecurityRoutingModule } from './security-routing.module';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AccessDeniedComponent } from './access-denied/access-denied.component';


@NgModule({
    declarations: [LoginComponent, AccessDeniedComponent],
    exports: [
        LoginComponent
    ],
    imports: [
        CommonModule,
        SecurityRoutingModule,
        FormsModule,
        ReactiveFormsModule
    ]
})
export class SecurityModule { }
