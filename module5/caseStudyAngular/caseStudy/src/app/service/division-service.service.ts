import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Level} from '../level';
import {Division} from '../division';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class DivisionServiceService {

  constructor(private  http: HttpClient) { }
  findAll(): Observable<Division[]> {
    return this.http.get<Division[]>(API_URL + '/division');
  }
}
