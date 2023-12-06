import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {TokenStorageService} from '../service/security/token-storage.service';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    constructor(private router: Router,
                private tokenStorageService: TokenStorageService
    ) {
    }

    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
        const user = this.tokenStorageService.getUser();
        const user1 = this.tokenStorageService.getUser().roles[0];
        console.log(user1);
        console.log(route.data);
        if (user !== null) {
            const role = user.roles[0];
            if (!this.tokenStorageService.isAuthenticated() || route.data.expectedRole.indexOf(role) === -1) {
                this.router.navigate(['/auth/access-denied']);
                return false;
            }
            return true;
        }
        this.router.navigate(['/auth/access-denied']);
        return false;

    }
}
