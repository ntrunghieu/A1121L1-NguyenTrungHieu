import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';
import {AccountServiceService} from '../../service/account/account-service.service';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {SecurityServiceService} from '../../service/security/security-service.service';
import {Router} from '@angular/router';
import {ShareService} from '../../service/security/share.service';
import {HeaderComponent} from '../../header/header.component';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    username: string;
    password: string;
    roles: string[] = [];
    errorMessage = '';

    checkUserName = false;

    checkPassWord = false;
    isLoggedIn: boolean;
    urlImg: string;
    role: string;
    idEmployee: any;
    constructor(private formBuilder: FormBuilder,
                private tokenStorageService: TokenStorageService,
                private securityService: SecurityServiceService,
                private router: Router,
                private shareService: ShareService,
                private headerComponent: HeaderComponent) {
    }

    ngOnInit(): void {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required],
            remember_me: false
        });
        if (this.tokenStorageService.getUser()) {
            this.securityService.isLoggedIn = true;
            this.role = this.tokenStorageService.getUser().roles[0].roleName;
            this.username = this.tokenStorageService.getUser().account.username;
            this.router.navigate(['']);

        }
    }

    login() {
        console.log(this.loginForm.value.username);
        this.securityService.login(this.loginForm.value).subscribe(data => {
                console.log(data);
                if (this.loginForm.value.remember_me === true) {
                    this.tokenStorageService.saveUserLocal(data);
                    this.tokenStorageService.saveTokenLocal(data.jwtToken);
                } else if (this.loginForm.value.remember_me === false) {
                    this.tokenStorageService.saveUserSession(data);
                    this.tokenStorageService.saveTokenSession(data.jwtToken);
                    // this.username = this.loginFrom.controls.username.value;
                }

                this.isLoggedIn = true;
                this.username = this.tokenStorageService.getUser().account.username;
                this.role = this.tokenStorageService.getUser().account.roles.roleName;
                console.log('username: ' + this.tokenStorageService.getUser().account.username);
                console.log('role: ' + this.tokenStorageService.getUser().account.roles[0].roleName);
                console.log('token: ' + this.tokenStorageService.getUser().jwtToken);
                console.log('token: ' + this.tokenStorageService.getUser().account.accountId);

                // this.loginForm.reset();
                // if (this.role.indexOf('ROLE_ADMIN') !== -1) {
                //     this.router.navigate(['/account/create']);
                //     this.shareService.sendClickEvent();
                //
                // } else {
                //     this.router.navigate(['/customer/list']);
                //     this.shareService.sendClickEvent();
                // }
            }
            , error => {
                if (this.loginForm.value.username === '') {
                    // this.errorMessage1 = 'Tài khoản không được để trống';
                    this.checkUserName = true;
                }
                if (this.loginForm.value.password === '') {
                    // this.errorMessage1 = 'Tài khoản không được để trống';
                    this.checkPassWord = true;
                }
                console.log(error);
                this.isLoggedIn = false;
                this.errorMessage = 'Tài khoản hoặc mật khẩu không đúng';
            },
            () => {
                window.location.assign('');
                this.router.navigateByUrl('');
            });
    }
    private loadRememberInfo() {
        if (this.tokenStorageService.getUser()) {
            this.role = this.tokenStorageService.getUser().account.roles[0];
            console.log(this.role);
            this.username = this.tokenStorageService.getUser().account.username;
            console.log(this.username);
            this.urlImg = this.tokenStorageService.getUser().urlImg;
        } else {
            this.role = null;
            this.username = null;
            this.urlImg = null;
            this.idEmployee = null;
        }
        this.isLoggedIn = this.username != null;
    }
}
