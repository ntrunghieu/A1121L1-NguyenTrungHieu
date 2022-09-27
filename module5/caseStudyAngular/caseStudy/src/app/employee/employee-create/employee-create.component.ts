import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeServiceService} from '../../service/employee-service.service';
import {Router} from '@angular/router';
import {Division} from '../../division';
import {Level} from '../../level';
import {LevelServiceService} from '../../service/level-service.service';
import {PositionServiceService} from '../../service/position-service.service';
import {DivisionServiceService} from '../../service/division-service.service';

// import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css'],
})
export class EmployeeCreateComponent implements OnInit {
  employeeForm: FormGroup;
  positionList: Position[];
  levelList: Level[]=[];
  divisionList: Division[]=[];
  constructor(private service: EmployeeServiceService,
              private route: Router,
              private levelService: LevelServiceService,
              private positionService: PositionServiceService,
              private divisionService: DivisionServiceService
              ) { }

  ngOnInit(): void {
    this.employeeForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', [Validators.required, Validators.minLength(6)]),
      idCard: new FormControl('', [Validators.required,Validators.minLength(10), Validators.maxLength(12)]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-z][a-z0-9_.]{0,32}@[a-z0-9]{2,}(.[a-z0-9]{2,4}){1,2}$')]),
      birthday: new FormControl('', [Validators.required]),
      level: new FormControl('' ,[Validators.required]),
      position: new FormControl('',[Validators.required] ),
      division: new FormControl('',[Validators.required]),
      salary: new FormControl('', [Validators.required, Validators.min(0)]),

    });
    this.getLevelList();
    this.getDivisionList();
    this.getPositionLList();
  }
  addSuccess() {
    // this.messageService.add({severity:'success', summary:'Service Message', detail:'Ban da them moi nhan vien '});
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
    this.service.createEmployee(this.employeeForm.value).subscribe(data => {
      console.log(data);

      // this.messageService.add({severity:'success', summary:'Service Message', detail:'Ban da them moi nhan vien '+ this.employeeForm.value.name + ' thanh cong'});
      // alert('Ban da them moi nhan vien ' + this.employeeForm.value.name);
      this.route.navigateByUrl('/employee');
    }, () => {
      console.log('error');
    });
  }

  back() {
    this.route.navigateByUrl('/employee');
  }
}
