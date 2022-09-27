import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {FacilityRentType} from '../facility-rent-type';
import {FacilityType} from '../facility-type';
import {FacilityRentTypeServiceService} from '../service/facility-rent-type-service.service';
import {FacilityTypeServiceService} from '../service/facility-type-service.service';
import {FacilityServiceService} from '../service/facility-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  serviceForm: FormGroup;
  rentType: FacilityRentType[] = [];
  facilityType: FacilityType[] = [];
  constructor(private rentTypeService: FacilityRentTypeServiceService,
              private facilityTypeService: FacilityTypeServiceService,
              private facilityService: FacilityServiceService,
              private route: Router) { }

  ngOnInit(): void {
    this.serviceForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      cost: new FormControl(''),
      floor: new FormControl(''),
      poolArea: new FormControl(''),
      area: new FormControl(''),
      standard: new FormControl(''),
      maxPeople: new FormControl(''),
      description: new FormControl(''),
      facilityType: new FormControl(''),
      rentType: new FormControl(''),
      url: new FormControl('')
    });
    this.getRentType();
    this.getFacilityType();
  }

  onSubmit() {
    this.facilityService.createFacility(this.serviceForm.value).subscribe(data => {
      console.log(data);
      // this.messageService.add({severity:'success', summary:'Service Message', detail:'Ban da them moi nhan vien '+ this.employeeForm.value.name + ' thanh cong'});
      // alert('Ban da them moi nhan vien ' + this.employeeForm.value.name);
      this.route.navigateByUrl('');
    }, () => {
      console.log('error');
    });
  }

  back() {
    this.route.navigateByUrl('');
  }



  getRentType() {
    this.rentTypeService.findAll().subscribe((data) => {
      this.rentType = data;
    });
  }
  getFacilityType() {
    this.facilityTypeService.findAll().subscribe((data) => {
      this.facilityType = data;
    });
}
}
