import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EmployeeServiceService} from '../service/employee-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {LevelServiceService} from '../service/level-service.service';
import {PositionServiceService} from '../service/position-service.service';
import {DivisionServiceService} from '../service/division-service.service';
import {FacilityServiceService} from '../service/facility-service.service';
import {FacilityRentTypeServiceService} from '../service/facility-rent-type-service.service';
import {FacilityTypeServiceService} from '../service/facility-type-service.service';
import {Facility} from '../facility';
import {FacilityRentType} from '../facility-rent-type';
import {FacilityType} from '../facility-type';

@Component({
  selector: 'app-service-update',
  templateUrl: './service-update.component.html',
  styleUrls: ['./service-update.component.css']
})
export class ServiceUpdateComponent implements OnInit {
  updateServiceForm: FormGroup;
  facilities: Facility;
  id: number;
  rentType: FacilityRentType[] = [];
  facilityType: FacilityType[] = [];
  constructor(private rentTypeService: FacilityRentTypeServiceService,
              private facilityTypeService: FacilityTypeServiceService,
              private facilityService: FacilityServiceService,
              private route: Router,
              private activated: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.id = this.activated.snapshot.params.id;
    this.facilityService.findByIdService(this.id).subscribe(
      data => {
        this.facilities = data;
        console.log(this.facilities);
      }
    );

    this.updateServiceForm = new FormGroup({
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
    console.log(this.updateServiceForm.value);
    this.facilityService.updateService(this.id, this.updateServiceForm.value).subscribe(
      data => {
        console.log('success');
        this.route.navigateByUrl('');
      }
    );
  }

  back() {
    this.route.navigateByUrl('');
  }

  compareObjects(o1: any, o2: any) {
    if(o1.name == o2.name && o1.id == o2.id )
      return true;
    else return false
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
