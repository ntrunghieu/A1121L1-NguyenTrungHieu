import { Component, OnInit } from '@angular/core';
import {FacilityServiceService} from '../service/facility-service.service';
import {Router} from '@angular/router';
import {Employee} from '../employee';
import {Facility} from '../facility';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  facilities: Facility[] = [];
  constructor(private facilityService: FacilityServiceService,
              private router: Router,) { }

  ngOnInit(): void {
    this.getFacilityList();
    console.log(this.facilities.values().next());
  }

  getFacilityList() {
    this.facilityService.findAll().subscribe((data) => {
      this.facilities = data;
      // this.totalLength = data.length;
    });
  }

}
