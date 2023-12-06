import { Component, OnInit } from '@angular/core';
import {IEmployee} from '../../model/employee/iemployee';
import {IPositionEmployee} from '../../model/employee/iposition-employee';
import {Router} from '@angular/router';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import {FormControl, FormGroup} from '@angular/forms';
import {NotifierService} from 'angular-notifier';



@Component({
    selector: 'app-list-employee',
    templateUrl: './list-employee.component.html',
    styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

    positionEmployees: IPositionEmployee[];
    positionEmployee: IPositionEmployee;
    totalPagination: Array<any>;
    totalItems: number;
    id: any;
    page = 1;
    size: number;
    employeeDelete: IEmployee = {};
    name: any;
    code: any;
    listEmployee: IEmployee[] = [];
    searchNameForm: FormGroup;


    constructor(private router: Router,
                private employeeService: EmployeeServiceService,
                private notification: NotifierService) { }

    ngOnInit(): void {
        // this.getAllEmployeeWithPagination();
        this.getEmployeeList(this.page);
        // this.getEmployeeList(this.page);
        this.searchNameForm = new FormGroup({
            name: new FormControl('')
        });
    }

    // getAllEmployeeWithPagination() {
    //     this.employeeService.getAllEmployeeWithPagination(this.page).subscribe(
    //         (data) => {
    //             this.listEmployee = data;
    //             console.log(data.length);
    //         });
    // }

    // previous(event: any) {
    //     event.preventDefault();
    //     console.log(this.page);
    //     if (this.page <= 0) {
    //         this.page = 0;
    //         this.getAllEmployeeWithPagination();
    //     } else {
    //         this.page = this.page - 5;
    //         this.employeeService.getAllEmployeeWithPagination(this.page).subscribe((data: IEmployee[]) => {
    //             this.listEmployee = data;
    //         });
    //     }
    // }

    // next(event: any) {
    //     event.preventDefault();
    //     this.page = this.page + 5;
    //     if (this.page >= this.totalPagination.length * 5) {
    //         this.page = this.totalPagination.length * 5 - 5;
    //         this.getAllEmployeeWithPagination();
    //     }
    //     this.getAllEmployeeWithPagination();
    // }
    //
    // setPage(i, event: any) {
    //     event.preventDefault();
    //     this.page = i * 5;
    //     this.getAllEmployeeWithPagination();
    // }

    showInfoEmployeeDelete(employeeTable: IEmployee) {
        this.employeeDelete = employeeTable;
        this.id = employeeTable.employeeId;
        this.name = employeeTable.employeeName;
        this.code = employeeTable.employeeCode;
    }

    deleteEmployee(employeeId: number) {
        this.employeeService.deleteEmployeeById(employeeId).subscribe(
            () => {
            },
            (error) => {
                if (error.status === 500) {
                    this.router.navigateByUrl('/auth/access-denied');
                }
            },
            () => {
                this.getEmployeeList(this.page);
                // this.getImportListNotPagination();
                this.notification.notify('success', 'Xoá lịch sử nhập kho thành công');
            });
    }

    sendEmployeeToDelete(employeeId: number, employeeName: string) {
        this.name = employeeName;
        this.code = employeeId;
    }

    // deleteEmployeeById(id: number) {
    //     this.employeeService.deleteEmployeeById(id).subscribe(
    //         () => { this.getEmployeeList(this.page - 1);
    //         },
    //         () => {},
    //         () => {
    //             alert('Xóa nhân viên ' + this.name + ' thành công');
    //             // this.getAllEmployeeWithPagination();
    //         }
    //     );
    // }
    // private getAllEmployee() {
    //     this.employeeService.getAllEmployee().subscribe(
    //         (data) => {
    //             this.listEmployeeNotPagination = data;
    //             console.log(Math.round(this.listEmployeeNotPagination.length / 5));
    //             if ((this.listEmployeeNotPagination.length % 5) !== 0) {
    //                 this.totalPagination = new Array((Math.round(this.listEmployeeNotPagination.length / 5)) + 1 );
    //             }
    //             console.log(data.length);
    //         });
    // }

    // send() {
    //     if (this.searchNameForm.get('name').value === '') {
    //         this.page = 0;
    //         // this.getAllEmployeeWithPagination();
    //         this.totalPagination = new Array((Math.round(this.listEmployeeNotPagination.length / 5) )  );
    //     } else {
    //         this.employeeService.searchEmployeeByName(this.searchNameForm.get('name').value).subscribe(
    //             (data) => {
    //                 this.listEmployee = data;
    //                 this.message = '';
    //                 this.totalPagination = new Array((Math.round(this.listEmployeeNotPagination.length / this.listEmployeeNotPagination.length)));
    //                 console.log(this.totalPagination.length);
    //             },
    //             (error) => {
    //                 if (error.status === 500) {
    //                     this.router.navigateByUrl('/auth/access-denied');
    //                 }
    //             },
    //             () => {
    //                 if (this.listEmployee.length === 0) {
    //                     this.page = 0;
    //                     this.message = 'Nhân viên đã xóa hoặc không tồn tại';
    //                     this.getAllEmployee();
    //                     // this.getAllEmployeeWithPagination();
    //                 }
    //             });
    //     }
    // }

    getEmployeeList(page: number) {
      this.page = page;
      this.employeeService.findAllEmployee(this.page - 1).subscribe((data: any) => {
          this.listEmployee = data.content;
          this.size = data.size;
          this.totalItems = data.totalElements;
          console.log(this.totalItems);
        },
        () => {
          this.page--;
          this.getEmployeeList(this.page);
        }
      );
    }
}
