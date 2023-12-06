import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import { Router} from '@angular/router';
import {IPositionEmployee} from '../../model/employee/iposition-employee';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';
import {NotifierService} from 'angular-notifier';
import {IEmployee} from '../../model/employee/iemployee';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
    // tslint:disable-next-line:max-line-length
    constructor(private employeeService: EmployeeServiceService, private router: Router, private storage: AngularFireStorage , private notification: NotifierService) {
    }
    uploadedAvatar = null;
    id: number;
    positions: IPositionEmployee[] = [];
    employeeForm: FormGroup;
    url: any;
    checkCreate = false;
    employeeErr: IEmployee;

    ngOnInit(): void {
        console.log(1);
        this.getListPosition();
        this.employeeForm = new FormGroup({
            employeeCode: new FormControl('', [Validators.required, Validators.pattern('^MNV-\\d{3}$')]),
            // tslint:disable-next-line:max-line-length
            employeeName: new FormControl('', [Validators.required, Validators.maxLength(50), Validators.pattern('^[A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*([ ][A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*)*$')]),
            employeeAvatar: new FormControl('', []),
            employeeDateOfBirth: new FormControl('', [this.checkAge]),
            employeeGender: new FormControl('', []),
            employeeAddress: new FormControl('', [Validators.maxLength(60)]),
            employeePhone: new FormControl('', [Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]),
            employeeSalary: new FormControl('', [Validators.required]),
            employeePositionId: new FormControl('', [])
        });
    }
    createEmployee() {
        this.checkCreate = false;
        this.employeeForm.markAllAsTouched();
        this.employeeForm.markAsDirty();
        console.log(this.employeeForm.value.employeePositionId);
        if (this.employeeForm.invalid) {
            Object.values(this.employeeForm.controls).forEach((control) => {
                if (control.invalid) {
                    control.markAsDirty();
                    control.updateValueAndValidity({onlySelf: true});
                    console.log(control);
                }

            });
            this.checkCreate = true;
            return;
        }
        if (this.uploadedAvatar !== null) {
            // Upload img & download url
            const avatarName = this.getCurrentDateTime() + this.uploadedAvatar.name;
            // @ts-ignore
            const fileRef = this.storage.ref(avatarName);
            // @ts-ignore
            this.storage.upload(avatarName, this.uploadedAvatar).snapshotChanges().pipe(
                finalize(() => {
                    fileRef.getDownloadURL().subscribe(url => {
                        this.employeeForm.patchValue({employeeAvatar: url});
                        // Create employee
                        console.log(this.employeeForm.value);
                        this.employeeService.saveEmployee(this.employeeForm.value).subscribe(
                            () => {
                            },
                            (error) => {
                                if (error.status === 500) {
                                    this.router.navigateByUrl('/auth/access-denied');
                                }
                                if (error.status === 400) {
                                    this.employeeErr = error.error;
                                }
                            },
                            () => {
                                alert('Tạo mới thành công');
                                this.uploadedAvatar = null;
                                this.employeeForm.reset();
                                this.router.navigateByUrl('/employee/list');
                            },
                        );
                    });
                })
            ).subscribe();
        } else {
            console.log(this.employeeForm.value);
            this.employeeService.saveEmployee(this.employeeForm.value).subscribe(
                () => {
                },
                (error) => {
                    if (error.status === 500) {
                        this.router.navigateByUrl('/auth/access-denied');
                    }
                    if (error.status === 400) {
                        this.employeeErr = error.error;
                    }
                },
                () => {
                    alert('Tạo mới thành công');
                    this.employeeForm.reset();
                    this.router.navigateByUrl('/employee/list' );
                }
            );
        }
    }
    getAvatar(event: any) {
        this.uploadedAvatar = event.target.files[0];
        if (event.target.files) {
            const reader = new FileReader();
            reader.readAsDataURL(this.uploadedAvatar);
            reader.onload = (e: any) => {
                this.url = e.target.result;
            };
        }
    }
    private getCurrentDateTime() {
        return new Date().getTime();
    }

    private getListPosition() {
        this.employeeService.getListPosition().subscribe((res: IPositionEmployee[]) => {
            console.log(res);
            this.positions = res;
        });
    }
    checkAge(control: AbstractControl): ValidationErrors | null {
        const employeeDateOfBirth = control.value;
        const birthday = new Date(employeeDateOfBirth);
        const currentDate = new Date();
        const age = currentDate.getFullYear() - birthday.getFullYear();
        return age > 18 ? null : {invalidAge: true};
    }
}
