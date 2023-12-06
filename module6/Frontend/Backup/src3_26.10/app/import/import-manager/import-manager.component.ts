import {Component, DoCheck, OnInit} from '@angular/core';
import {ICustomer} from '../../model/customer/icustomer';
import {ImportServiceService} from '../../service/import/import-service.service';
import {IImport} from '../../model/iimport';
import {IEmployee} from '../../model/employee/iemployee';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {IMaterialType} from '../../model/material/imaterial-type';
import {IMaterial} from '../../model/material/imaterial';
import {IAccount} from '../../model/account/iaccount';
import {NotifierService} from 'angular-notifier';
import {formatDate} from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-import-manager',
  templateUrl: './import-manager.component.html',
  styleUrls: ['./import-manager.component.css']
})
export class ImportManagerComponent implements OnInit {
  importSearchForm: FormGroup;
  importForm: FormGroup;
  importUpdateForm: FormGroup;
  checkQuantityMaterial = 0;
  date1 = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');
  checkFormEdit = false;
  importListString: string[] = [];
  importExistCreate = '';
  importExistCreateSearch = '';
  importExistUpdate = '';
  importExistUpdateSearch = '';
  materialListString: string[] = [];
  materialExistUpdate = '';
  materialExistUpdateSearch = '';

  customerList: ICustomer[] = [];
  employeeList: IEmployee[] = [];
  materialList: IMaterial[] = [];
  customerId: ICustomer = {};
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

  page = 1;
  size: number;
  totalItems: number;

  constructor(
    private importService: ImportServiceService,
    private notification: NotifierService,
    private router: Router
  ) {
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

    this.importForm = new FormGroup({
      importCode: new FormControl('', [Validators.required, Validators.pattern('HDN-\\d{3}')]),
      importStartDate: new FormControl(this.date1, [Validators.required]),
      importQuantity: new FormControl('', [Validators.required, Validators.min(0)]),
      importAccountId: new FormControl('', [Validators.required]),
      importMaterialId: new FormControl('', [Validators.required]),
      materialCustomerId: new FormControl('', [Validators.required])
    });

    this.importUpdateForm = new FormGroup({
      importCodeUpdate: new FormControl('', [Validators.required, Validators.pattern('HDN-\\d{3}')]),
      importStartDateUpdate: new FormControl('', [Validators.required]),
      importQuantityUpdate: new FormControl('', [Validators.required, Validators.min(0)]),
      importAccountIdUpdate: new FormControl('', [Validators.required]),
      importMaterialCodeUpdate: new FormControl('', [Validators.required, Validators.pattern('MVT-\\d{3}')]),
      importMaterialNameUpdate: new FormControl('', [Validators.required]),
      importMaterialUnitUpdate: new FormControl('', [Validators.required])
    });
  }

  // +++++++++++++++lấy dữ liệu++++++++++++++++
  getCustomerList() {
    this.importService.findAllCustomerImport().subscribe((data: ICustomer[]) => {
      this.customerList = data;
      this.customerId = data[0];
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

  getMaterialImportListByCustomerId() {
    this.importService.findAllMaterialImport(this.customerId.customerId).subscribe((data: IMaterial[]) => {
      this.materialList = data;
    });
  }

  showMaterialList(customerId: any) {
    this.customerId = customerId;
    this.getMaterialImportListByCustomerId();
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
        // this.getImportListNotPagination();
        this.notification.notify('success', 'Xoá lịch sử nhập kho thành công');
      });
  }

// ++++++++++++++++++create+++++++++++++
  createImport1() {
    this.importCreate = {
      importCode: this.importForm.get('importCode').value,
      importStartDate: this.importForm.get('importStartDate').value,
      importQuantity: this.importForm.get('importQuantity').value,
      importAccountId: this.importForm.get('importAccountId').value.employeeAccountId,
      importMaterialId: this.importForm.get('importMaterialId').value
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
        this.importForm.reset();
        this.page = 1;
        this.getImportList(this.page);
        this.notification.notify('success', 'Thêm mới số lượng vật tư nhập kho thành công');
      }
    );
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
    });
  }

  // +++++++++++Edit+++++++++++++
  compareFn(c1: IEmployee, c2: IAccount): boolean {
    return c1.employeeAccountId.accountId === c2.accountId;
  }

  close(b: boolean) {
    this.checkFormEdit = b;
  }

  showFormEdit(checkFormEdit: boolean, importId: number) {
    this.importForm.reset();
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
          this.checkQuantityMaterial = 0;
          this.importForm.reset();
          this.importUpdateForm.reset();
          this.getImportList(this.page);
          this.notification.notify('success', 'cập nhật đơn hàng nhập kho thành công');
        }
      );
    } else {
      // tslint:disable-next-line:max-line-length
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
        if (this.importForm.get('importCode').valid) {
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

// +++search+++++
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
      }, (error) => {
        if (error.status === 500) {
          this.router.navigateByUrl('/auth/access-denied');
        }
      }
    );
  }
}
