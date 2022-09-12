import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Contract} from '../contract';
import {Facility} from '../facility';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class FacilityServiceService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>(API_URL + '/facility');
  }
}
