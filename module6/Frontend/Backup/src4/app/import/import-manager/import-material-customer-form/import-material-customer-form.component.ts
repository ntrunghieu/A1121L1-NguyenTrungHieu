import {Component, ElementRef, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ICustomer} from '../../../model/customer/icustomer';
import {IEmployee} from '../../../model/employee/iemployee';
import {IImport} from '../../../model/iimport';
import {IMaterialType} from '../../../model/material/imaterial-type';
import {IMaterial} from '../../../model/material/imaterial';
import {ImportServiceService} from '../../../service/import/import-service.service';
import {IAccount} from '../../../model/account/iaccount';
import {NotifierService} from 'angular-notifier';
import {formatDate} from '@angular/common';
import {Router} from '@angular/router';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';
import {ViewChild} from '@angular/core';
import {checkHSD} from "../../../validate/customvalidator.validator";

@Component({
    selector: 'app-import-material-customer-form',
    templateUrl: './import-material-customer-form.component.html',
    styleUrls: ['./import-material-customer-form.component.css']
})
export class ImportMaterialCustomerFormComponent implements OnInit {
    importForm3: FormGroup;
    importUpdateForm: FormGroup;
    importSearchForm: FormGroup;
    checkQuantityMaterial = 0;
    date1 = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');
    checkFormEdit = false;
    importListString: string[] = [];
    importExistCreate = '';
    importExistUpdate = '';
    materialListString: string[] = [];
    materialExistCreate = '';
    materialExistCreateSearch = '';

    importExistCreateSearch = '';
    importExistUpdateSearch = '';
    materialExistUpdateSearch = '';

    materialExistUpdate = '';
    phoneCustomerListString: string[] = [];
    phoneCustomerExistCreate = '';
    emailCustomerListString: string[] = [];
    emailCustomerExistCreate = '';

    customerCodeExistCreateSearch = '';
    phoneCustomerExistCreateSearch = '';
    emailCustomerExistCreateSearch = '';

    customerListString: string[] = [];
    customerExistCreate = '';
    customerList: ICustomer[] = [];
    employeeList: IEmployee[] = [];
    materialTypeList: IMaterialType[] = [];
    importList: IImport[] = [];
    importDelete: IImport = {};
    importBeforeUpdate: IImport = {
        importAccountId: {},
        importMaterialId: {}
    };
    importUpdate: IImport = {
        importAccountId: {},
        importMaterialId: {}
    };
    accountTempUpdateImport: IAccount = {};
    importIdTemp: number;
    importCreate: IImport = null;
    materialCreate: IMaterial = {
        materialTypeId: {},
        materialCustomerId: {}
    };
    customerCreate: ICustomer = {
        customerTypeId: {}
    };


    page = 1;
    size: number;
    totalItems: number;

    upLoadImageMaterial = null;
    urlMaterial: any;
    @ViewChild('avatarMaterial')
    myInputVariableMaterial: ElementRef;

    upLoadImageCustomer = null;
    urlCustomer: any;
    @ViewChild('avatarCustomer')
    myInputVariableCustomer: ElementRef;

    loading = false;


    constructor(private importService: ImportServiceService,
                private notification: NotifierService,
                private router: Router,
                private storage: AngularFireStorage) {
    }

    ngOnInit(): void {
        this.notification.notify('default', 'Vui nhập thông tin nhập kho');
        this.getCustomerList();
        this.getEmployeeList();
        this.getImportList(this.page);
        this.getMaterialTypeImportList();
        this.importSearchForm = new FormGroup({
            codeSearch: new FormControl(''),
            startDateSearch: new FormControl(''),
            endDateSearch: new FormControl('')
        });

        this.importForm3 = new FormGroup({
            importCode: new FormControl('', [Validators.required, Validators.pattern('HDN-\\d{3}')]),
            importStartDate: new FormControl(this.date1, [Validators.required]),
            importQuantity: new FormControl('', [Validators.required, Validators.min(0)]),
            importAccountId: new FormControl('', [Validators.required]),
            materialCode: new FormControl('', [Validators.required, Validators.pattern('MVT-\\d{3}')]),
            materialName: new FormControl('', [Validators.required]),
            materialPrice: new FormControl('', [Validators.required, Validators.min(0)]),
            materialExpiridate: new FormControl(null, [Validators.required]),
            materialUnit: new FormControl('', [Validators.required]),
            materialImage: new FormControl(''),
            materialDescribe: new FormControl(''),
            materialTypeId: new FormControl('', [Validators.required]),
            customerName: new FormControl('', [Validators.required]),
            customerCode: new FormControl('', [Validators.required, Validators.pattern('MKH-\\d{3}')]),
            customerAddress: new FormControl('', [Validators.required]),
            // tslint:disable-next-line:max-line-length
            customerPhone: new FormControl('', [Validators.required, Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]),
            customerEmail: new FormControl('', [Validators.required, Validators.email]),
            customerAvatar: new FormControl('')
        }, checkHSD);

        this.importUpdateForm = new FormGroup({
            importCodeUpdate: new FormControl(null, [Validators.required, Validators.pattern('HDN-\\d{3}')]),
            importStartDateUpdate: new FormControl(null, [Validators.required]),
            importQuantityUpdate: new FormControl(null, [Validators.required, Validators.min(0)]),
            importAccountIdUpdate: new FormControl(null, [Validators.required]),
            importMaterialCodeUpdate: new FormControl(null, [Validators.required, Validators.pattern('MVT-\\d{3}')]),
            importMaterialNameUpdate: new FormControl(null, [Validators.required]),
            importMaterialUnitUpdate: new FormControl(null, [Validators.required])
        });
    }

    // ++++thêm mới+++++++
    createImport3() {
        this.loading = true;
        if (this.upLoadImageMaterial !== null && this.upLoadImageCustomer !== null) {
            const avatarNameMaterial = this.getCurrentDateTime() + this.upLoadImageMaterial.name;
            const fileRefMaterial = this.storage.ref(avatarNameMaterial);
            this.storage.upload(avatarNameMaterial, this.upLoadImageMaterial).snapshotChanges().pipe(
                finalize(() => {
                    fileRefMaterial.getDownloadURL().subscribe(url => {
                        // cập nhật lại đường dẫn url
                        this.importForm3.patchValue({materialImage: url});
                    });
                })
            ).subscribe(() => {
            }, () => {
            }, () => {
                const avatarNameCustomer = this.getCurrentDateTime() + this.upLoadImageCustomer.name;
                const fileRefCustomer = this.storage.ref(avatarNameCustomer);
                this.storage.upload(avatarNameCustomer, this.upLoadImageCustomer).snapshotChanges().pipe(
                    finalize(() => {
                        fileRefCustomer.getDownloadURL().subscribe(url => {
                            // cập nhật lại đường dẫn url
                            this.importForm3.patchValue({customerAvatar: url});
                            this.customerCreate = {
                                customerName: this.importForm3.get('customerName').value,
                                customerCode: this.importForm3.get('customerCode').value,
                                customerAddress: this.importForm3.get('customerAddress').value,
                                customerPhone: this.importForm3.get('customerPhone').value,
                                customerEmail: this.importForm3.get('customerEmail').value,
                                customerAvatar: this.importForm3.get('customerAvatar').value,
                                customerTypeId: {
                                    customerTypeId: 3,
                                    customerTypeName: 'nhà cung cấp',
                                    customerTypeFlag: false
                                }
                            };

                            this.materialCreate = {
                                materialCode: this.importForm3.get('materialCode').value,
                                materialName: this.importForm3.get('materialName').value,
                                materialQuantity: 0,
                                materialPrice: this.importForm3.get('materialPrice').value,
                                materialExpiridate: this.importForm3.get('materialExpiridate').value,
                                materialUnit: this.importForm3.get('materialUnit').value,
                                materialTypeId: this.importForm3.get('materialTypeId').value,
                                materialCustomerId: this.customerCreate,
                                materialImage: this.importForm3.get('materialImage').value,
                                materialDescribe: this.importForm3.get('materialDescribe').value
                            };

                            this.importCreate = {
                                importCode: this.importForm3.get('importCode').value,
                                importStartDate: this.importForm3.get('importStartDate').value,
                                importQuantity: this.importForm3.get('importQuantity').value,
                                importAccountId: this.importForm3.get('importAccountId').value.employeeAccountId,
                                importMaterialId: this.materialCreate
                            };


                            this.importService.createImport(this.importCreate).subscribe(
                                () => {
                                },
                                (error) => {
                                    if (error.status === 500) {
                                        this.router.navigateByUrl('/auth/access-denied');
                                    }
                                },
                                () => {
                                    this.loading = false;
                                    this.myInputVariableMaterial.nativeElement.value = '';
                                    this.upLoadImageMaterial = null;
                                    this.urlMaterial = null;
                                    this.myInputVariableCustomer.nativeElement.value = '';
                                    this.upLoadImageCustomer = null;
                                    this.urlCustomer = null;
                                    this.importForm3.reset();
                                    this.page = 1;
                                    this.getImportList(this.page);
                                    this.notification.notify('success', 'Thêm mới vật tư nhập kho thành công');
                                }
                            );
                        });
                    })
                ).subscribe();
            });
        } else if (this.upLoadImageMaterial !== null) {
            const avatarNameMaterial = this.getCurrentDateTime() + this.upLoadImageMaterial.name;
            const fileRefMaterial = this.storage.ref(avatarNameMaterial);
            this.storage.upload(avatarNameMaterial, this.upLoadImageMaterial).snapshotChanges().pipe(
                finalize(() => {
                    fileRefMaterial.getDownloadURL().subscribe(url => {
                        // cập nhật lại đường dẫn url
                        this.importForm3.patchValue({materialImage: url});

                        this.customerCreate = {
                            customerName: this.importForm3.get('customerName').value,
                            customerCode: this.importForm3.get('customerCode').value,
                            customerAddress: this.importForm3.get('customerAddress').value,
                            customerPhone: this.importForm3.get('customerPhone').value,
                            customerEmail: this.importForm3.get('customerEmail').value,
                            customerAvatar: this.importForm3.get('customerAvatar').value,
                            customerTypeId: {
                                customerTypeId: 3,
                                customerTypeName: 'nhà cung cấp',
                                customerTypeFlag: false
                            }
                        };

                        this.materialCreate = {
                            materialCode: this.importForm3.get('materialCode').value,
                            materialName: this.importForm3.get('materialName').value,
                            materialQuantity: 0,
                            materialPrice: this.importForm3.get('materialPrice').value,
                            materialExpiridate: this.importForm3.get('materialExpiridate').value,
                            materialUnit: this.importForm3.get('materialUnit').value,
                            materialTypeId: this.importForm3.get('materialTypeId').value,
                            materialCustomerId: this.customerCreate,
                            materialImage: this.importForm3.get('materialImage').value,
                            materialDescribe: this.importForm3.get('materialDescribe').value
                        };

                        this.importCreate = {
                            importCode: this.importForm3.get('importCode').value,
                            importStartDate: this.importForm3.get('importStartDate').value,
                            importQuantity: this.importForm3.get('importQuantity').value,
                            importAccountId: this.importForm3.get('importAccountId').value.employeeAccountId,
                            importMaterialId: this.materialCreate
                        };


                        this.importService.createImport(this.importCreate).subscribe(
                            () => {
                            },
                            (error) => {
                                if (error.status === 500) {
                                    this.router.navigateByUrl('/auth/access-denied');
                                }
                            },
                            () => {
                                this.loading = false;
                                this.myInputVariableMaterial.nativeElement.value = '';
                                this.upLoadImageMaterial = null;
                                this.urlMaterial = null;
                                this.importForm3.reset();
                                this.page = 1;
                                this.getImportList(this.page);
                                this.notification.notify('success', 'Thêm mới vật tư nhập kho thành công');
                            }
                        );
                    });
                })
            ).subscribe();
        } else if (this.upLoadImageCustomer !== null) {
            const avatarNameCustomer = this.getCurrentDateTime() + this.upLoadImageCustomer.name;
            const fileRefCustomer = this.storage.ref(avatarNameCustomer);
            this.storage.upload(avatarNameCustomer, this.upLoadImageCustomer).snapshotChanges().pipe(
                finalize(() => {
                    fileRefCustomer.getDownloadURL().subscribe(url => {
                        // cập nhật lại đường dẫn url
                        this.importForm3.patchValue({customerAvatar: url});
                        this.customerCreate = {
                            customerName: this.importForm3.get('customerName').value,
                            customerCode: this.importForm3.get('customerCode').value,
                            customerAddress: this.importForm3.get('customerAddress').value,
                            customerPhone: this.importForm3.get('customerPhone').value,
                            customerEmail: this.importForm3.get('customerEmail').value,
                            customerAvatar: this.importForm3.get('customerAvatar').value,
                            customerTypeId: {
                                customerTypeId: 3,
                                customerTypeName: 'nhà cung cấp',
                                customerTypeFlag: false
                            }
                        };

                        this.materialCreate = {
                            materialCode: this.importForm3.get('materialCode').value,
                            materialName: this.importForm3.get('materialName').value,
                            materialQuantity: 0,
                            materialPrice: this.importForm3.get('materialPrice').value,
                            materialExpiridate: this.importForm3.get('materialExpiridate').value,
                            materialUnit: this.importForm3.get('materialUnit').value,
                            materialTypeId: this.importForm3.get('materialTypeId').value,
                            materialCustomerId: this.customerCreate,
                            materialImage: this.importForm3.get('materialImage').value,
                            materialDescribe: this.importForm3.get('materialDescribe').value
                        };

                        this.importCreate = {
                            importCode: this.importForm3.get('importCode').value,
                            importStartDate: this.importForm3.get('importStartDate').value,
                            importQuantity: this.importForm3.get('importQuantity').value,
                            importAccountId: this.importForm3.get('importAccountId').value.employeeAccountId,
                            importMaterialId: this.materialCreate
                        };


                        this.importService.createImport(this.importCreate).subscribe(
                            () => {
                            },
                            (error) => {
                                if (error.status === 500) {
                                    this.router.navigateByUrl('/auth/access-denied');
                                }
                            },
                            () => {
                                this.loading = false;
                                this.myInputVariableCustomer.nativeElement.value = '';
                                this.upLoadImageCustomer = null;
                                this.urlCustomer = null;
                                this.importForm3.reset();
                                this.page = 1;
                                this.getImportList(this.page);
                                this.notification.notify('success', 'Thêm mới vật tư nhập kho thành công');
                            }
                        );
                    });
                })
            ).subscribe();
        } else {
            this.customerCreate = {
                customerName: this.importForm3.get('customerName').value,
                customerCode: this.importForm3.get('customerCode').value,
                customerAddress: this.importForm3.get('customerAddress').value,
                customerPhone: this.importForm3.get('customerPhone').value,
                customerEmail: this.importForm3.get('customerEmail').value,
                customerAvatar: this.importForm3.get('customerAvatar').value,
                customerTypeId: {
                    customerTypeId: 3,
                    customerTypeName: 'nhà cung cấp',
                    customerTypeFlag: false
                }
            };

            this.materialCreate = {
                materialCode: this.importForm3.get('materialCode').value,
                materialName: this.importForm3.get('materialName').value,
                materialQuantity: 0,
                materialPrice: this.importForm3.get('materialPrice').value,
                materialExpiridate: this.importForm3.get('materialExpiridate').value,
                materialUnit: this.importForm3.get('materialUnit').value,
                materialTypeId: this.importForm3.get('materialTypeId').value,
                materialCustomerId: this.customerCreate,
                materialImage: this.importForm3.get('materialImage').value,
                materialDescribe: this.importForm3.get('materialDescribe').value
            };

            this.importCreate = {
                importCode: this.importForm3.get('importCode').value,
                importStartDate: this.importForm3.get('importStartDate').value,
                importQuantity: this.importForm3.get('importQuantity').value,
                importAccountId: this.importForm3.get('importAccountId').value.employeeAccountId,
                importMaterialId: this.materialCreate
            };


            this.importService.createImport(this.importCreate).subscribe(
                () => {
                },
                (error) => {
                    if (error.status === 500) {
                        this.router.navigateByUrl('/auth/access-denied');
                    }
                },
                () => {
                    this.loading = false;
                    this.importForm3.reset();
                    this.page = 1;
                    this.getImportList(this.page);
                    this.notification.notify('success', 'Thêm mới vật tư nhập kho thành công');
                }
            );
        }
    }

    // +++++firebase++++
    showPreviewMaterial(e: any) {
        this.upLoadImageMaterial = e.target.files[0];
        if (e.target.files) {
            // để lấy url truyền lên image
            const reader = new FileReader();
            reader.readAsDataURL(this.upLoadImageMaterial);
            reader.onload = (event: any) => {
                this.urlMaterial = event.target.result;
            };
        }
    }

    showPreviewCustomer(e: any) {
        this.upLoadImageCustomer = e.target.files[0];
        if (e.target.files) {
            // để lấy url truyền lên image
            const reader = new FileReader();
            reader.readAsDataURL(this.upLoadImageCustomer);
            reader.onload = (event: any) => {
                this.urlCustomer = event.target.result;
            };
        }
    }

    getCurrentDateTime() {
        return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
    }

    // ++++++++++++++PDF++++++++++++
    pdfImport() {
        this.importService.getPdfImport(this.importCreate).subscribe(x => {
            const blob = new Blob([x], {type: 'application/pdf'});
            if (window.navigator && window.navigator.msSaveOrOpenBlob) {
                window.navigator.msSaveOrOpenBlob(blob);
                return;
            }
            const data = window.URL.createObjectURL(blob);
            const link = document.createElement('a');
            link.href = data;
            link.download = 'invoice.pdf';
            link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));
            // tslint:disable-next-line:only-arrow-functions
            setTimeout(() => {
                window.URL.revokeObjectURL(data);
                link.remove();
            }, 100);
        }, (error) => {
            if (error.status === 500) {
                this.router.navigateByUrl('/auth/access-denied');
            }
        });
    }

    // +++++++++++++++lấy dữ liệu++++++++++++++++
    getCustomerList() {
        this.importService.findAllCustomerImport().subscribe((data: ICustomer[]) => {
            this.customerList = data;
        });
    }

    getEmployeeList() {
        this.importService.findAllEmployeeImport().subscribe((data: IEmployee[]) => {
            this.employeeList = data;
        });
    }

    getImportList(page: number) {
        this.page = page;
        this.importService.findAllImport(this.page - 1).subscribe((data: any) => {
                this.importList = data.content;
                this.size = data.size;
                this.totalItems = data.totalElements;
            },
            () => {
                this.page--;
                this.getImportList(this.page);
            }
        );
    }

    getMaterialTypeImportList() {
        this.importService.findAllMaterialTypeImport().subscribe((data: IMaterialType[]) => {
            this.materialTypeList = data;
        });
    }

    // +++++++++++++xoá++++++++++++++
    showInfoImportDelete(importTable: IImport) {
        this.importDelete = importTable;
    }

    deleteImport(importId: number) {
        this.importService.deleteImport(importId).subscribe(
            () => {
            },
            (error) => {
                if (error.status === 500) {
                    this.router.navigateByUrl('/auth/access-denied');
                }
            },
            () => {
                this.getImportList(this.page);
                this.notification.notify('success', 'Xoá lịch sử nhập kho thành công');
            });
    }

// +++++++++update++++++++++++
    compareFn(c1: IEmployee, c2: IAccount): boolean {
        return c1.employeeAccountId.accountId === c2.accountId;
    }

    close(b: boolean) {
        this.checkFormEdit = b;
    }

    showFormEdit(checkFormEdit: boolean, importId: number) {
        this.importForm3.reset();
        this.importIdTemp = importId;
        this.checkFormEdit = checkFormEdit;
        this.importService.findImportById(importId).subscribe((data) => {
                this.importUpdateForm = new FormGroup({
                    importCodeUpdate: new FormControl(data.importCode, [Validators.required, Validators.pattern('HDN-\\d{3}')]),
                    importStartDateUpdate: new FormControl(data.importStartDate, [Validators.required]),
                    importQuantityUpdate: new FormControl(data.importQuantity, [Validators.required, Validators.min(0)]),
                    importAccountIdUpdate: new FormControl(data.importAccountId, [Validators.required]),
                    // tslint:disable-next-line:max-line-length
                    importMaterialCodeUpdate: new FormControl(data.importMaterialId.materialCode, [Validators.required, Validators.pattern('MVT-\\d{3}')]),
                    importMaterialNameUpdate: new FormControl(data.importMaterialId.materialName, [Validators.required]),
                    importMaterialUnitUpdate: new FormControl(data.importMaterialId.materialUnit, [Validators.required])
                });
                this.importBeforeUpdate = data;
                this.checkQuantityMaterial = data.importMaterialId.materialQuantity - data.importQuantity;
            }
        );
    }

    updateImport() {
        // tslint:disable-next-line:radix
        if ((this.checkQuantityMaterial + parseInt(this.importUpdateForm.get('importQuantityUpdate').value)) >= 0) {
            if (this.importUpdateForm.get('importAccountIdUpdate').value.employeeAccountId !== undefined) {
                this.accountTempUpdateImport = this.importUpdateForm.get('importAccountIdUpdate').value.employeeAccountId;
            } else {
                this.accountTempUpdateImport = this.importBeforeUpdate.importAccountId;
            }
            this.checkFormEdit = false;
            this.importUpdate = {
                importId: this.importBeforeUpdate.importId,
                importCode: this.importUpdateForm.get('importCodeUpdate').value,
                importStartDate: this.importUpdateForm.get('importStartDateUpdate').value,
                importQuantity: this.importUpdateForm.get('importQuantityUpdate').value,
                importFlag: false,
                importAccountId: this.accountTempUpdateImport,
                importMaterialId: {
                    materialId: this.importBeforeUpdate.importMaterialId.materialId,
                    materialCode: this.importUpdateForm.get('importMaterialCodeUpdate').value,
                    materialName: this.importUpdateForm.get('importMaterialNameUpdate').value,
                    materialPrice: this.importBeforeUpdate.importMaterialId.materialPrice,
                    materialQuantity: this.importBeforeUpdate.importMaterialId.materialQuantity,
                    materialExpiridate: this.importBeforeUpdate.importMaterialId.materialExpiridate,
                    materialImage: this.importBeforeUpdate.importMaterialId.materialImage,
                    materialDescribe: this.importBeforeUpdate.importMaterialId.materialDescribe,
                    materialFlag: false,
                    materialUnit: this.importUpdateForm.get('importMaterialUnitUpdate').value,
                    materialTypeId: this.importBeforeUpdate.importMaterialId.materialTypeId,
                    materialCustomerId: this.importBeforeUpdate.importMaterialId.materialCustomerId
                }
            };

            this.importService.updateImport(this.importUpdate.importId, this.importUpdate).subscribe(
                () => {
                },
                (error) => {
                    if (error.status === 500) {
                        this.router.navigateByUrl('/auth/access-denied');
                    }
                },
                () => {
                    this.importForm3.reset();
                    this.importUpdateForm.reset();
                    this.getImportList(this.page);
                    this.notification.notify('success', 'cập nhật đơn hàng nhập kho thành công');
                }
            );
        } else {
            this.notification.notify('error', 'Số lượng vật tư hiện tại nhỏ hơn 0 sau khi cập nhật, vui lòng kiểm tra lại số lượng nhập kho');
            this.checkFormEdit = false;
        }
    }

    // ++check code import tồn tại++
    checkImportCode() {
        this.importService.findAllImportString().subscribe(data => {
                this.importListString = data;
            }, () => {
            },
            () => {
                if (this.importForm3.get('importCode').valid) {
                    if (this.importListString.indexOf(this.importExistCreateSearch) > -1) {
                        this.importExistCreate = 'Mã nhập kho đã tồn tại';
                    } else {
                        this.importExistCreate = '';
                    }
                } else {
                    this.importExistCreate = '';
                }
            });
    }

    checkImportCodeUpdate() {
        this.importService.findAllImportString().subscribe(data => {
                this.importListString = data;
            }, () => {
            },
            () => {
                if (this.importUpdateForm.get('importCodeUpdate').valid) {
                    // tslint:disable-next-line:max-line-length
                    if (this.importListString.indexOf(this.importExistUpdateSearch) > -1 && this.importExistUpdateSearch !== this.importBeforeUpdate.importCode) {
                        this.importExistUpdate = 'Mã nhập kho đã tồn tại';
                    } else {
                        this.importExistUpdate = '';
                    }
                } else {
                    this.importExistUpdate = '';
                }
            });
    }

    checkMaterialCode() {
        this.importService.findAllMaterialString().subscribe(data => {
            this.materialListString = data;
        }, () => {
        }, () => {
            if (this.importForm3.get('materialCode').valid) {
                if (this.materialListString.indexOf(this.materialExistCreateSearch) > -1) {
                    this.materialExistCreate = 'Mã Vật tư đã tồn tại';
                } else {
                    this.materialExistCreate = '';
                }
            } else {
                this.materialExistCreate = '';
            }
        });
    }

    checkMaterialCodeUpdate() {
        this.importService.findAllMaterialString().subscribe(data => {
            this.materialListString = data;
        }, () => {
        }, () => {
            if (this.importUpdateForm.get('importMaterialCodeUpdate').valid) {
                // tslint:disable-next-line:max-line-length
                if (this.materialListString.indexOf(this.materialExistUpdateSearch) > -1 && this.materialExistUpdateSearch !== this.importBeforeUpdate.importMaterialId.materialCode) {
                    this.materialExistUpdate = 'Mã Vật tư đã tồn tại';
                } else {
                    this.materialExistUpdate = '';
                }
            } else {
                this.materialExistUpdate = '';
            }
        });
    }

    checkCustomerCode() {
        this.importService.findAllCustomerString().subscribe(data => {
            this.customerListString = data;
        }, () => {
        }, () => {
            if (this.importForm3.get('customerCode').valid) {
                if (this.customerListString.indexOf(this.customerCodeExistCreateSearch) > -1) {
                    this.customerExistCreate = 'Mã nhà cung cấp đã tồn tại';
                } else {
                    this.customerExistCreate = '';
                }
            } else {
                this.customerExistCreate = '';
            }
        });
    }

    checkPhoneCustomerCode() {
        this.importService.findAllPhoneCustomerString().subscribe(data => {
            this.phoneCustomerListString = data;
        }, () => {
        }, () => {
            if (this.importForm3.get('customerPhone').valid) {
                if (this.phoneCustomerListString.indexOf(this.phoneCustomerExistCreateSearch) > -1) {
                    this.phoneCustomerExistCreate = 'Số điện thoại nhà cung cấp đã tồn tại';
                } else {
                    this.phoneCustomerExistCreate = '';
                }
            } else {
                this.phoneCustomerExistCreate = '';
            }
        });
    }

    checkEmailCustomer() {
        this.importService.findAllEmailCustomerString().subscribe(data => {
            this.emailCustomerListString = data;
        }, () => {
        }, () => {
            if (this.importForm3.get('customerEmail').valid) {
                if (this.emailCustomerListString.indexOf(this.emailCustomerExistCreateSearch) > -1) {
                    this.emailCustomerExistCreate = 'Email nhà cung cấp đã tồn tại';
                } else {
                    this.emailCustomerExistCreate = '';
                }
            } else {
                this.emailCustomerExistCreate = '';
            }
        });
    }

    // +++++++++search++++++
    searchImport() {
        this.importService.searchImport(
            this.importSearchForm.get('codeSearch').value,
            this.importSearchForm.get('startDateSearch').value,
            this.importSearchForm.get('endDateSearch').value,
            0
        ).subscribe(
            (data: any) => {
                this.importList = data.content;
                this.size = data.size;
                this.totalItems = data.totalElements;
                this.page = 1;
            }
        );
    }
}
