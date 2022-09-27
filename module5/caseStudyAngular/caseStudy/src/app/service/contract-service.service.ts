import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../customer';
import {Contract} from '../contract';
import {Employee} from '../employee';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class ContractServiceService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(API_URL + '/contract');
  }
  addContract(contract: Contract): Observable<Contract> {
    return this.httpClient.post<Contract>(API_URL + '/contract', contract);
  }

  searchName(value: string): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(API_URL + '/contract?employee.name_like=' + value);
  }
}
