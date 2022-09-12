import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Level} from '../level';
const API_URL = 'http://localhost:3000';

@Injectable({
  providedIn: 'root'
})
export class PositionServiceService {

  constructor(private http: HttpClient) { }
  findAll(): Observable<Position[]> {
    return this.http.get<Position[]>(API_URL + '/position');
  }
}
