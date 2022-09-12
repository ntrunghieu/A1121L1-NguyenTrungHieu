import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {Employee} from '../../employee';
import {Router} from '@angular/router';
import {EmployeeServiceService} from '../../service/employee-service.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  totalLength: number;
  page: number = 1;
  deleteEmp: Employee = {};
  employee: Employee[] = [];
  employeeIdToDelete: number;
  employeeNameToDelete: string;
  name: any;
  constructor( private router: Router,
               private service: EmployeeServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }

  sendEmployeeToDelete(id: number, name: string) {
    this.employeeIdToDelete = id;
    this.employeeNameToDelete = name;
  }

  delete(employeeIdToDelete: number) {
    this.service.delete(employeeIdToDelete).subscribe(
      () => {},
      () => {},
      () => {
        this.getAll()
      }
    )
  }
  getAll() {
    this.service.findAll().subscribe((data) => {
      this.employee = data;
      this.totalLength = data.length;
    });
  }

  sendToDelete(employ: Employee) {
    this.deleteEmp=employ;
    console.log(employ.name);
  }

  search() {
    if (this.name==""){
      this.ngOnInit();
    }else {
      this.service.searchName(this.name).subscribe((data) => {
        this.employee = data;
        console.log(this.employee);
      });
      // this.employee= this.employee.filter(res => {
      //   return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      // });
    }
  }
  key: string='id';
  reverse: boolean = false;
  sort(key) {
    this.key=key;
    this.reverse= !this.reverse;
  }

  // backCustomer() {
  //   this.router.navigateByUrl("customer")
  // }
  //
  // backEmploy() {
  //   this.router.navigateByUrl("employee")
  // }
  //
  // backContract() {
  //   this.router.navigateByUrl("contract")
  // }
  //
  // backService() {
  //   this.router.navigateByUrl("")
  // }
}
