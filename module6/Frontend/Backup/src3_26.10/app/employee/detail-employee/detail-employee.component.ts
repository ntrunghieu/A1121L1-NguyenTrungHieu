import {Component, OnInit} from '@angular/core';
import {IEmployee} from '../../model/employee/iemployee';
import {EmployeeServiceService} from '../../service/employee/employee-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrls: ['./detail-employee.component.css']
})
export class DetailEmployeeComponent implements OnInit {
  employeeDetail: IEmployee = {
    employeeAccountId: {},
    employeePositionId: {}
  };
  idEmployee: number;

  constructor(private employeeService: EmployeeServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
      this.idEmployee = +param.get('id');
      this.findEmployeeById(this.idEmployee);
    });
  }

  findEmployeeById(idEmployee: number) {
    this.employeeService.findEmployeeById(idEmployee).subscribe(
      (data) => {
        this.employeeDetail = data;
      },
      (error) => {
        if (error.status === 404) {
          this.router.navigateByUrl('/error404');
        }
      });
  }
}
