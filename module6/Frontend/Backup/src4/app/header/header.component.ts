import {Component, Injectable, OnInit} from '@angular/core';
import {TokenStorageService} from '../service/security/token-storage.service';
import {Router} from '@angular/router';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
@Injectable({
    providedIn: 'root'
})
export class HeaderComponent implements OnInit {
    private roles: string[];
    isLoggedIn = false;
    showAdminBoard = false;
    showAccountantBoard = false;
    showSellBoard = false;
    userName: string;
    constructor(private tokenStorageService: TokenStorageService,
                private router: Router) { }

    ngOnInit(): void {
        this.isLoggedIn = !!this.tokenStorageService.getToken();
        if (this.isLoggedIn) {
            this.userName = this.tokenStorageService.getUser().account.username;
            this.roles = this.tokenStorageService.getUser().account.roles[0].roleName;
            this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
            this.showAccountantBoard = this.roles.includes('ROLE_ACCOUNTANT');
            this.showSellBoard = this.roles.includes('ROLE_SELL');

            console.log('roles: ' + this.roles);
        }
    }
    logout() {
        this.tokenStorageService.signOut();
        window.location.assign('');
        this.router.navigateByUrl('');
    }
}
