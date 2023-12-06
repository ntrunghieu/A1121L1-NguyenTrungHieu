import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Password} from '../../../model/classDTO/password';
import {AccountServiceService} from '../../../service/account/account-service.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  // AnDVH thay đổi mật khẩu
  passwordForm: FormGroup;
  accountId: number;
  updatePassword: Password = {};
  error = false;

  constructor(private accountService: AccountServiceService, private fb: FormBuilder, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.passwordForm = this.fb.group({
      oldPassword: ['', [Validators.required]],
      passwordGroup: this.fb.group({
        newPassword: ['', [Validators.required, Validators.maxLength(20), Validators.minLength(8), Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$')]],
        confirmPassword: ['', [Validators.required]]
      }, {validator: this.comparePassword}),
    });
  }
  changePassword() {
    const formValue = this.passwordForm.value;
    this.updatePassword.oldPassword = formValue.oldPassword;
    this.updatePassword.newPassword = formValue.passwordGroup.newPassword;
    this.updatePassword.confirmPassword = formValue.passwordGroup.confirmPassword;

    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.accountId = Number(paramMap.get('id'));
      this.accountService.updatePassword(this.accountId, this.updatePassword).subscribe(
        () => {
        },
        (error) => {
          if (error.status === 500) {
            this.router.navigateByUrl('/auth/access-denied');
          }
          if (error.status === 400) {
            this.error = true;
            window.alert("Vui lòng kiểm tra lại thông tin");
          }
        },
        () => {
          this.router.navigateByUrl('');
          console.log('success');
        }
      );
    });
  }

  comparePassword(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    return (value.newPassword === value.confirmPassword) ? null : {invalidConfirmation: true};
  }
}
