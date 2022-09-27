import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {FacilityType} from '../facility-type';
import {Level} from '../level';
import {FacilityRentType} from '../facility-rent-type';
import {HttpClient} from '@angular/common/http';
const API_URL = 'http://localhost:3000';

@Injectable({
  providedIn: 'root'
})
export class FacilityRentTypeServiceService {

  constructor(private http: HttpClient) { }
  findAll(): Observable<FacilityRentType[]> {
    return this.http.get<FacilityRentType[]>(API_URL + '/rentType');
  }
}
