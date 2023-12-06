import { Component, OnInit } from '@angular/core';
import {IEmployee} from '../../model/employee/iemployee';
import {IPositionEmployee} from '../../model/employee/iposition-employee';
import {Router} from '@angular/router';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import {FormControl, FormGroup} from '@angular/forms';



@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  // employees: IEmployee[];
  // employee: IEmployee;
  positionEmployees: IPositionEmployee[];
  positionEmployee: IPositionEmployee;
  totalPagination: Array<any>;
  page = 0;
  pageCurrent: any;
  indexCurrent: any;
  name: any;
  id: any;
  listEmployeeNotPagination: IEmployee[] = [];
  listEmployee: IEmployee[] = [];
  searchNameForm: FormGroup;


  constructor(private router: Router,
              private employeeService: EmployeeServiceService) { }

  ngOnInit(): void {
    this.getAllEmployeeWithPagination();
    this.getAllEmployee();
    this.searchNameForm = new FormGroup({
      name: new FormControl('')
    });
  }

  getAllEmployeeWithPagination() {
    this.employeeService.getAllEmployeeWithPagination(this.page).subscribe(
      (data) => {
        this.listEmployee = data;
        console.log(data.length);
      });
  }

  previous(event: any) {
    event.preventDefault();
    console.log(this.page);
    if (this.page <= 0) {
      this.page = 0;
      this.getAllEmployeeWithPagination();
    } else {
      this.page = this.page - 5;
      this.employeeService.getAllEmployeeWithPagination(this.page).subscribe((data: IEmployee[]) => {
        this.listEmployee = data;
      });
    }
  }

  next(event: any) {
    event.preventDefault();
    this.page = this.page + 5;
    if (this.page >= this.totalPagination.length * 5) {
      this.page = this.totalPagination.length * 5 - 5;
      this.getAllEmployeeWithPagination();
    }
    this.getAllEmployeeWithPagination();
  }

  setPage(i, event: any) {
    event.preventDefault();
    this.page = i * 5;
    this.getAllEmployeeWithPagination();
  }

  sendEmployeeToDelete(employeeCode: string, employeeName: string) {
    this.name = employeeName;
    this.id = employeeCode;
  }

  deleteEmployeeById(id: number) {
    this.employeeService.deleteEmployeeById(id).subscribe(
      () => { this.getAllEmployee();
      },
      () => {},
      () => {
        this.getAllEmployeeWithPagination();
      }
    );
  }
  private getAllEmployee() {
    this.employeeService.getAllEmployee().subscribe(
      (data) => {
        this.listEmployeeNotPagination = data;
        console.log(Math.round(this.listEmployeeNotPagination.length / 5));
        if ((this.listEmployeeNotPagination.length % 5) !== 0) {
          this.totalPagination = new Array((Math.round(this.listEmployeeNotPagination.length / 5)) + 1 );
        }
        console.log(data.length);
      });
  }

  send() {
    if (this.searchNameForm.get('name').value === '') {
      this.page = 0;
      this.getAllEmployeeWithPagination();
      this.totalPagination = new Array((Math.round(this.listEmployeeNotPagination.length / 5) )  );
    } else {
      this.employeeService.searchEmployeeByName(this.searchNameForm.get('name').value).subscribe(
        (data) => {
          this.listEmployee = data;
          this.totalPagination = new Array((Math.round(this.listEmployeeNotPagination.length / this.listEmployeeNotPagination.length)  )  );
          console.log(this.totalPagination.length);
        },
        (error) => {
          if (error.status === 500) {
            this.router.navigateByUrl('/auth/access-denied');
          }
        },
        () => {
        });
    }
  }
}
