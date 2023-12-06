import {Component, OnInit} from '@angular/core';
import {AccountServiceService} from '../../service/account/account-service.service';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import {IPositionEmployee} from '../../model/employee/iposition-employee';
import {IEmployee} from '../../model/employee/iemployee';
import {checkAge} from '../../validate/customvalidator.validator';
import {NotifierService} from 'angular-notifier';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  createForm: FormGroup;
  code: string;
  positionList: IPositionEmployee[];
  employee: IEmployee;
  confirmPassCheck: string;
  errorMessageAccountAndEmployeeExist: string;
  errorMessageEmployeeExist: string;
  usernameAlreadyExist: string;
  phoneAlreadyExist: string;
  usernameList: string[] = [];
  employeeHasAccountList: string[] = [];
  employeeDontHasAccountList: string[] = [];
  phoneList: string[] = [];
  existCode: string;
  existUsername: string;
  existPhone: string;
  date: string;
  checkBirth: string;
  private readonly notifier: NotifierService;

  constructor(private accountService: AccountServiceService, private employeeService: EmployeeServiceService,
              private formBuilder: FormBuilder, private router: Router, notifierService: NotifierService) {
    this.notifier = notifierService;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      employee: this.formBuilder.group({
        employeeCode: ['', [Validators.required, Validators.maxLength(19), Validators.pattern('^MNV-[0-9]{3}$')]],
        employeeName: ['', [Validators.required, Validators.maxLength(49), Validators.minLength(8), Validators.pattern('^[A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*([ ][A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*)*$')]],
        employeeDateOfBirth: ['', [Validators.required, checkAge]],
        employeeGender: ['', [Validators.required]],
        employeeAddress: ['', [Validators.required, Validators.maxLength(59), Validators.minLength(5)]],
        employeePhone: ['', [Validators.required, Validators.maxLength(19),  Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]],
        employeePositionId: ['', [Validators.required]]
      }),
      account: this.formBuilder.group({
        username: ['', [Validators.required, Validators.maxLength(19), Validators.minLength(5), Validators.pattern('^[a-z]|[0-9]{8,20}$')]],
        password: ['', [Validators.required, Validators.maxLength(19), Validators.minLength(8), Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$')]],
        confirmPassword: ['', [Validators.required]],
      })
    });
    this.getPositionNotManager();
    this.getAllUsernames();
    this.getAllEmployeeHasAccount();
    this.getAllEmployeeDontHasAccount();
    this.getAllPhone();
    // @ts-ignore
    this.createForm.setValidators(this.passValidator(this.createForm.get('account').get('password'), this.createForm.get('account').get('confirmPassword')));
    this.focusInput();
  }

  submit() {
    const employeeAccount = this.createForm.value;
    this.accountService.createAccount(employeeAccount).subscribe(
      () => {
      }, (error) => {
        if (error.status === 403) {
          this.router.navigateByUrl('/auth/access-denied');
        } else if (this.confirmPassCheck !== '') {
          this.notifier.notify('error', 'Thêm mới tài khoản không thành công!');
        } else {
          this.notifier.notify('error', 'Thêm mới tài khoản không thành công!');
        }
      }, () => {
        // alert('Thêm mới thành công.');
        this.notifier.notify('success', 'Thêm mới tài khoản thành công!');
        this.router.navigateByUrl('/account/create');
        this.createForm.reset();
        this.focusInput();
        this.removeDisableInput();
        this.disableButton();
      });
  }
  focusInput() {
    const usernameInput = document.getElementById('username') as HTMLInputElement;
    usernameInput.focus();
    usernameInput.select();
  }
  backToHome() {
    this.router.navigate(['']);
  }

  getPositionNotManager() {
    this.employeeService.getPositionNotManager().subscribe(data => {
      this.positionList = data;
    });
  }

  getAllUsernames() {
    this.accountService.getAllUsername().subscribe(data => {
      this.usernameList = data;
    });
  }

  getAllEmployeeHasAccount() {
    this.employeeService.getAllEmployeeHasAccount().subscribe(data => {
      this.employeeHasAccountList = data;
    });
  }

  getAllEmployeeDontHasAccount() {
    this.employeeService.getAllEmployeeDontHasAccount().subscribe(data => {
      this.employeeDontHasAccountList = data;
    });
  }

  getAllPhone() {
    this.employeeService.getAllPhone().subscribe(data => {
      this.phoneList = data;
    });
  }

  disableButton() {
    const button = document.getElementById('btnAdd') as HTMLButtonElement | null;
    button?.setAttribute('disabled', '');
  }

  removeDisableButton() {
    const button = document.getElementById('btnAdd') as HTMLButtonElement | null;
    button?.removeAttribute('disabled');
  }

  disableInput() {
    const nameInput = document.getElementById('name') as HTMLInputElement | null;
    nameInput?.setAttribute('disabled', '');
    const birthdayInput = document.getElementById('birthday') as HTMLInputElement | null;
    birthdayInput?.setAttribute('disabled', '');
    const genderInput = document.getElementById('gender1') as HTMLInputElement | null;
    genderInput?.setAttribute('disabled', '');
    const addressInput = document.getElementById('address') as HTMLInputElement | null;
    addressInput?.setAttribute('disabled', '');
    const phoneInput = document.getElementById('phone') as HTMLInputElement | null;
    phoneInput?.setAttribute('disabled', '');
  }

  removeDisableInput() {
    const nameInput = document.getElementById('name') as HTMLInputElement | null;
    nameInput?.removeAttribute('disabled');
    const birthdayInput = document.getElementById('birthday') as HTMLInputElement | null;
    birthdayInput?.removeAttribute('disabled');
    const genderInput = document.getElementById('gender1') as HTMLInputElement | null;
    genderInput?.removeAttribute('disabled');
    const addressInput = document.getElementById('address') as HTMLInputElement | null;
    addressInput?.removeAttribute('disabled');
    const phoneInput = document.getElementById('phone') as HTMLInputElement | null;
    phoneInput?.removeAttribute('disabled');
  }

  getEmployee(code: string) {
    this.employeeService.getEmployeeByCode(code).subscribe(employee => {
      document.getElementById('name').setAttribute('value', employee.employeeName);
      document.getElementById('birthday').setAttribute('value', employee.employeeDateOfBirth);
      document.getElementById('gender1').setAttribute('value', employee.employeeGender);
      document.getElementById('phone').setAttribute('value', employee.employeePhone);
    });
  }

  resetInput() {
    this.createForm.get('employee').get('employeeName').reset();
    this.createForm.get('employee').get('employeeDateOfBirth').reset();
    this.createForm.get('employee').get('employeeGender').reset();
    this.createForm.get('employee').get('employeeAddress').reset();
    this.createForm.get('employee').get('employeePhone').reset();
  }

  checkCode() {
    if (this.employeeHasAccountList.indexOf(this.existCode) > -1) {
      this.errorMessageAccountAndEmployeeExist = 'Mã nhân viên đã tồn tại và đã có tài khoản.';
      const button = document.getElementById('btnAdd') as HTMLButtonElement | null;
      button?.setAttribute('disabled', '');
    } else {
      this.errorMessageAccountAndEmployeeExist = '';
      if (this.employeeDontHasAccountList.indexOf(this.existCode) > -1) {
        this.errorMessageEmployeeExist = 'Mã nhân viên đã tồn tại.';
        this.resetInput();
        this.getEmployee(this.existCode);
        this.disableInput();
        this.removeDisableButton();
      } else {
        this.errorMessageEmployeeExist = '';
        const button = document.getElementById('btnAdd') as HTMLButtonElement | null;
        button?.setAttribute('disabled', '');
        this.removeDisableInput();
      }
    }
  }
  // isFutureDate(idate) {
  //   const today = new Date().getTime();
  //   idate = idate.split('-');
  //
  //   idate = new Date(idate[0], idate[1] - 1, idate[2]).getTime();
  //   return (today - idate) < 0 ? true : false;
  // }
  passValidator(control: AbstractControl, controlTwo: AbstractControl): () => (string | null) {
    return () => {
      if (control.value !== controlTwo.value) {
        return this.confirmPassCheck = 'Nhập lại mật khẩu chưa đúng.';
      }
      return this.confirmPassCheck = '';
    };
  }

  checkUsername() {
    if (this.usernameList.indexOf(this.existUsername) > -1) {
      this.usernameAlreadyExist = 'Tên tài khoản đã tồn tại.';
    } else {
      this.usernameAlreadyExist = '';
    }
  }

  checkPhone() {
    if (this.phoneList.indexOf(this.existPhone) > -1) {
      this.phoneAlreadyExist = 'Số điện thoại đã tồn tại.';
    } else {
      this.phoneAlreadyExist = '';
    }
  }
}
