import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IEmployee} from '../../model/employee/iemployee';
import {IPositionEmployee} from '../../model/employee/iposition-employee';

class AngularFireStorage {

}

@Component({
  selector: 'app-admin-edit-employee',
  templateUrl: './admin-edit-employee.component.html',
  styleUrls: ['./admin-edit-employee.component.css']
})
export class AdminEditEmployeeComponent implements OnInit {
  employee: IEmployee;
  employees: IEmployee[] = [];
  positions: IPositionEmployee[] = [];
  formEdit = new FormGroup({});

  // tslint:disable-next-line:max-line-length
  constructor(private activatedRoute: ActivatedRoute,
              private employeeServiceService: EmployeeServiceService,
              private formBuilder: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    this.initForm();
    this.getListPosition();
    this.activatedRoute.paramMap.subscribe(
      (param) => {
        const id = +param.get('id');
        this.employeeServiceService.findEmployeeById(id).subscribe(
          data => {
            this.employee = data;
            console.log(data);
            console.log(this.employee.employeePositionId);
            this.initForm(data);
          });
      });
  }

  private findAllPosition() {

  }

  checkAge(control: AbstractControl): ValidationErrors | null {
    const employeeDateOfBirth = control.value;
    const birthday = new Date(employeeDateOfBirth);
    const currentDate = new Date();
    const age = currentDate.getFullYear() - birthday.getFullYear();
    return age > 18 ? null : {invalidAge: true};
  }

  initForm(data?: any) {
    this.formEdit = this.formBuilder.group({
      employeeId: new FormControl(data ? data.employeeId : []),
      employeeCode: new FormControl(data ? data.employeeCode : [], [Validators.required, Validators.pattern('[N][V][-]\\d{4}')]),
      // tslint:disable-next-line:max-line-length
      employeeName: new FormControl(data ? data.employeeName : [], [Validators.required, Validators.maxLength(50), Validators.pattern('^[A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*([ ][A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*)*$')]),
      employeeAvatar: new FormControl(data ? data.employeeAvatar : []),
      employeeDateOfBirth: new FormControl(data ? data.employeeDateOfBirth : [], this.checkAge),
      employeeGender: new FormControl(data ? data.employeeGender : []),
      employeeAddress: new FormControl(data ? data.employeeAddress : [], Validators.maxLength(60)),
      // tslint:disable-next-line:max-line-length
      employeePhone: new FormControl(data ? data.employeePhone : [], Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')),
      employeeSalary: new FormControl(data ? data.employeeSalary : []),
      employeeFlag: new FormControl(data ? data.employeeFlag : []),
      employeeAccountId: new FormControl(data ? data.employeeAccountId : []),
      employeePositionId: new FormControl(data ? data.employeePositionId : [])
    });
  }

  getListPosition() {
    this.employeeServiceService.getListPosition().subscribe((res: IPositionEmployee[]) => {
      console.log(res);
      this.positions = res;
    });
  }

  compareFn(c1: IPositionEmployee, c2: IPositionEmployee): boolean {
    return c1 && c2 ? c1.positionId === c2.positionId : c1 === c2;
  }

  onSubmit() {
    if (this.formEdit.valid) {
      this.employeeServiceService.adminUpdateEmployee(this.formEdit.value).subscribe(
        () => {
          alert('chỉnh sửa thành công');
        },
        (error) => {
          if (error.status === 500) {
            this.router.navigateByUrl('/auth/access-denied');
          }
        }
      );
    }
  }
}
