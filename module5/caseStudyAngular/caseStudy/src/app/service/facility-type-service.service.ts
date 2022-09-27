import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Level} from '../level';
import {FacilityType} from '../facility-type';
import {HttpClient} from '@angular/common/http';
const API_URL = 'http://localhost:3000';

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeServiceService {

  constructor(private http: HttpClient) { }
  findAll(): Observable<FacilityType[]> {
    return this.http.get<Level[]>(API_URL + '/facilityType');
  }
}
