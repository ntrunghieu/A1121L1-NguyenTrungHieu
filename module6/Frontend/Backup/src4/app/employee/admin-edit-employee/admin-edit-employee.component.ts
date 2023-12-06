import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IPositionEmployee} from '../../model/employee/iposition-employee';
import {finalize} from 'rxjs/operators';
import {AngularFireStorage} from '@angular/fire/storage';
import {IEmployee} from '../../model/employee/iemployee';

@Component({
  selector: 'app-admin-edit-employee',
  templateUrl: './admin-edit-employee.component.html',
  styleUrls: ['./admin-edit-employee.component.css']
})
export class AdminEditEmployeeComponent implements OnInit {
    employeeForm: FormGroup;
    employee: IEmployee;
    positions: IPositionEmployee[] = [];
    uploadedAvatar = null;
    oldAvatarLink: string;
    url: any;
    id: number;
    test: string;

// tslint:disable-next-line:max-line-length
    constructor(private employeeService: EmployeeServiceService, private fb: FormBuilder, private activatedRoute: ActivatedRoute, private router: Router, private storage: AngularFireStorage) {
    }

    ngOnInit(): void {
        this.findAllPosition();
        this.activatedRoute.paramMap.subscribe(paramMap => {
            this.id = Number(paramMap.get('id'));
            // @ts-ignore
            this.employeeService.findEmployeeById(this.id).subscribe(employee => {
                this.oldAvatarLink = employee.employeeAvatar;
                this.employeeForm = this.fb.group({
                    employeeId: [employee.employeeId, ],
                    employeeCode: [employee.employeeCode, [Validators.required, Validators.pattern('^MNV-\\d{3}$')]],
                    // tslint:disable-next-line:max-line-length
                    employeeName: [employee.employeeName, [Validators.required, Validators.maxLength(50), Validators.pattern('^[A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*([ ][A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*)*$')]],
                    employeeAvatar: [employee.employeeAvatar, ],
                    employeeDateOfBirth: [employee.employeeDateOfBirth, this.checkAge],
                    employeeGender: [employee.employeeGender, []],
                    employeeAddress: [employee.employeeAddress, [Validators.maxLength(60)]],
                    // tslint:disable-next-line:max-line-length
                    employeePhone: [employee.employeePhone, [Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]],
                    employeeSalary: [employee.employeeSalary, [Validators.required]],
                    employeeFlag: [employee.employeeFlag, []],
                    employeeAccountId: [employee.employeeAccountId, []],
                    employeePositionId: [employee.employeePositionId, []]
                });
            });
        });
    }

    adminEditEmployee() {
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

                        // delete old img from firebase
                        if (this.oldAvatarLink !== null) {
                            // @ts-ignore
                            this.storage.storage.refFromURL(this.oldAvatarLink).delete();
                        }
                        console.log(this.employeeForm.value);
                        // @ts-ignore
                        this.employeeService.adminUpdateEmployee(this.id, this.employeeForm.value).subscribe(
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
                            },
                            () => {
                                alert('chỉnh sửa thành công');
                                this.router.navigateByUrl('/employee/list');
                                this.uploadedAvatar = null;
                            }
                        );
                    });
                })
            ).subscribe();
        } else {
            // @ts-ignore
            this.employeeService.adminUpdateEmployee(this.id, this.employeeForm.value).subscribe(
                () => {
                },
                (error) => {
                    if (error.status === 500) {
                        this.router.navigateByUrl('/auth/access-denied');
                    }
                    if (error.status === 400) {
                        window.alert('Vui lòng kiểm tra lại thông tin');
                    }
                },
                () => {
                    alert('chỉnh sửa thành công');
                    this.router.navigateByUrl('/employee/list');
                }
            );
        }
    }

    getAvatar(event: any) {
        this.uploadedAvatar = event.target.files[0];
    }

    private getCurrentDateTime() {
        return new Date().getTime();
    }

    private findAllPosition() {
        this.employeeService.getListPosition().subscribe(next => {
            this.positions = next;
            console.log(this.positions);
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
