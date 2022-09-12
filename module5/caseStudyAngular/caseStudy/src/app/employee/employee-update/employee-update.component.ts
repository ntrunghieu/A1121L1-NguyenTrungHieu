import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Level} from '../../level';
import {Division} from '../../division';
import {EmployeeServiceService} from '../../service/employee-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {LevelServiceService} from '../../service/level-service.service';
import {PositionServiceService} from '../../service/position-service.service';
import {DivisionServiceService} from '../../service/division-service.service';
import {Employee} from '../../employee';

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit {
  employee: Employee;
  employeeForm: FormGroup;
  positionList: Position[];
  levelList: Level[]=[];
  divisionList: Division[]=[];
  id: number;
  constructor(private service: EmployeeServiceService,
              private route: Router,
              private levelService: LevelServiceService,
              private positionService: PositionServiceService,
              private divisionService: DivisionServiceService,
              private activated: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activated.snapshot.params.id;
    this.service.findByIdEmployee(this.id).subscribe(
      data => {
        this.employee = data;
        console.log(this.employee);
      }
    );

    this.employeeForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.email]),
      birthday: new FormControl('', [Validators.required]),
      level: new FormControl('', [Validators.required]),
      position: new FormControl('', [Validators.required]),
      division: new FormControl('', [Validators.required]),
      salary: new FormControl('', [Validators.required]),

    });
    this.getLevelList();
    this.getDivisionList();
    this.getPositionLList();
  }
  getLevelList() {
    this.levelService.findAll().subscribe((data) => {
      this.levelList = data;
    });
  }
  getPositionLList() {
    this.positionService.findAll().subscribe((data) => {
      this.positionList = data;
    });
  }
  getDivisionList() {
    this.divisionService.findAll().subscribe((data) => {
      this.divisionList = data;
    });
  }

  onSubmit() {
    console.log(this.employeeForm.value);
    this.service.updateEmployee(this.id, this.employeeForm.value).subscribe(
      data => {
        console.log('success');
        this.route.navigateByUrl('/employee');
      }
    );
  }

  back() {
    this.route.navigateByUrl('/employee');
  }
}
