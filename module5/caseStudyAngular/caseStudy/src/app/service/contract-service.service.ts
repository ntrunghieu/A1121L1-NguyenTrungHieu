import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../customer';
import {Contract} from '../contract';
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
}
