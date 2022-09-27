import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Contract} from '../contract';
import {Facility} from '../facility';
import {Employee} from '../employee';
const API_URL = ' http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class FacilityServiceService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>(API_URL+ '/facility' );
  }
  createFacility(facility: Facility): Observable<Facility> {
    return this.httpClient.post<Facility>(API_URL + '/facility', facility);
  }
  findByIdService(id: number): Observable<Facility> {
    return this.httpClient.get<Facility>(API_URL + '/facility/' + id);
  }
  updateService(id: number, facility: Facility): Observable<Employee> {
    return this.httpClient.put<Facility>(API_URL + '/facility/'+id, facility);
  }
  deleteService(id: number): Observable<Facility> {
    return this.httpClient.delete<Facility>(API_URL + '/facility/'+id);
  }
}
