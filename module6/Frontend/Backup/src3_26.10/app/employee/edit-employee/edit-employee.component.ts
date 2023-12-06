import {Component, OnInit} from '@angular/core';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {IEmployee} from '../../model/employee/iemployee';


@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  // AnDVH cập nhật thông tin nhân viên

  employeeForm: FormGroup;
  employee: IEmployee;
  oldAvatarLink = 'https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_960_720.png';
  uploadedAvatar = null;
  accountId: number;
  returnErrors: any;

  constructor(private employeeService: EmployeeServiceService, private fb: FormBuilder, private activatedRoute: ActivatedRoute, private router: Router, private storage: AngularFireStorage, private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.accountId = this.tokenStorageService.getUser().account.accountId;
    this.employeeService.findEmployeeByAccountId(this.accountId).subscribe(employee => {
      this.employee = employee;
      if (employee.employeeAvatar !== null) {
        this.oldAvatarLink = employee.employeeAvatar;
      }

      this.employeeForm = this.fb.group({
        employeeId: [employee.employeeId, []],
        employeeCode: [employee.employeeCode, []],
        employeeName: [employee.employeeName, [Validators.required, Validators.maxLength(50), Validators.pattern('^[A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*([ ][A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*)*$')]],
        employeeAvatar: [employee.employeeAvatar, []],
        employeeDateOfBirth: [employee.employeeDateOfBirth, [this.checkAge]],
        employeeGender: [employee.employeeGender, []],
        employeeAddress: [employee.employeeAddress, [Validators.maxLength(60)]],
        employeePhone: [employee.employeePhone, [Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]],
        employeeSalary: [employee.employeeSalary, []],
        employeeFlag: [employee.employeeFlag, []],
        employeeAccountId: [employee.employeeAccountId, []],
        employeePositionId: [employee.employeePositionId, []]
      });
    });
  }

  editEmployee() {
    if (this.uploadedAvatar !== null) {
      // Upload img & download url
      const avatarName = this.getCurrentDateTime() + this.uploadedAvatar.name;
      const fileRef = this.storage.ref(avatarName);
      this.storage.upload(avatarName, this.uploadedAvatar).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe(url => {
            this.employeeForm.patchValue({employeeAvatar: url});

            // delete old img from firebase
            if (this.employee.employeeAvatar !== null) {
              this.storage.storage.refFromURL(this.employee.employeeAvatar).delete();
            }

            // Update employee
            this.employeeService.updateEmployee(this.employee.employeeId, this.employeeForm.value).subscribe(
              () => {
              },
              (error) => {
                if (error.status === 500) {
                  this.router.navigateByUrl('/auth/access-denied');
                }
                console.log(error);
                if (error.status === 400) {
                  window.confirm('Vui lòng kiểm tra lại thông tin');
                }
                if (error.status === 404) {
                  window.confirm('Dữ liệu không tồn tại');
                }
              },
              () => {
                console.log('Success!');
                this.router.navigateByUrl('/employee/detail/' + this.employee.employeeId);
                this.uploadedAvatar = null;
              },
            );
          });
        })
      ).subscribe();
    } else {
      this.employeeService.updateEmployee(this.employee.employeeId, this.employeeForm.value).subscribe(
        () => {
        },
        (error) => {
          if (error.status === 500) {
            this.router.navigateByUrl('/auth/access-denied');
          }
          if (error.status === 400) {
            window.alert('Vui lòng kiểm tra lại thông tin');
            // this.returnErrors = error.error;
            // console.log(this.returnErrors.employeeName);
            // continue handle each error if needed
          }
        },
        () => {
          console.log('success');
          this.router.navigateByUrl('/employee/detail/' + this.employee.employeeId);
        }
      );
    }
  }

  getAvatar(event: any) {
    this.uploadedAvatar = event.target.files[0];
    if (this.uploadedAvatar) {
      const reader = new FileReader();
      reader.readAsDataURL(this.uploadedAvatar);
      reader.onload = (e: any) => {
        this.oldAvatarLink = e.target.result;
      };
    }
  }

  private getCurrentDateTime() {
    return new Date().getTime();
  }

  checkAge(control: AbstractControl): ValidationErrors | null {
    const employeeDateOfBirth = control.value;
    const birthday = new Date(employeeDateOfBirth);
    const currentDate = new Date();
    const age = currentDate.getFullYear() - birthday.getFullYear();
    return age > 18 ? null : {invalidAge: true};
  }
}
