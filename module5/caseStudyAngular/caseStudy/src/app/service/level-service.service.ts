import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../employee';
import {Level} from '../level';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class LevelServiceService {

  constructor(private  http: HttpClient) { }
  findAll(): Observable<Level[]> {
    return this.http.get<Level[]>(API_URL + '/level');
  }
}
