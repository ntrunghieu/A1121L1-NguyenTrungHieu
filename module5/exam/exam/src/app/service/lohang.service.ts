import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoHang} from "../loHang";
const API_URL = ' http://localhost:3000/lohang';
@Injectable({
  providedIn: 'root'
})
export class LohangService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>(API_URL);
  }
  findByIdLoHang(id: number): Observable<LoHang> {
    return this.httpClient.get<LoHang>(API_URL + '/' + id);
  }
  updateLoHang(id: number, loHang: LoHang): Observable<LoHang> {
    return this.httpClient.put<LoHang>(API_URL + '/' + id, loHang);
  }
  deleteLoHang(id: number): Observable<LoHang> {
    return this.httpClient.delete<LoHang>(API_URL + '/' + id);
  }
  createLoHang(loHang: LoHang): Observable<LoHang> {
    return this.httpClient.post<LoHang>(API_URL, loHang);
  }
  searchName(value: string): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>(API_URL + '/lohang?name_like=' + value);
  }
}
