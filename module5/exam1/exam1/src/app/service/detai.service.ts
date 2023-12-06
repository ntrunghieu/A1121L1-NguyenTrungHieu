import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SanPham} from '../model/sanpham';
import {Detai} from '../model/detai';
const API_URL = 'http://localhost:3000/detai';
@Injectable({
  providedIn: 'root'
})
export class DetaiService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<Detai[]> {
    return this.httpClient.get<Detai[]>(API_URL);
  }
  findByIdSP(id: number): Observable<Detai> {
    return this.httpClient.get<Detai>(API_URL + '/' + id);
  }
  updateSP(id: number, sp: Detai): Observable<Detai> {
    return this.httpClient.put<Detai>(API_URL + '/' + id, sp);
  }
  deleteSP(id: number): Observable<Detai> {
    return this.httpClient.delete<Detai>(API_URL + '/' + id);
  }
  createSP(sp: Detai): Observable<Detai> {
    return this.httpClient.post<Detai>(API_URL, sp);
  }
  searchName(value: string): Observable<Detai[]> {
    return this.httpClient.get<Detai[]>(API_URL + '?tenSV_like=' + value);
  }
  searchDate(value: string): Observable<Detai[]> {
    return this.httpClient.get<Detai[]>(API_URL + '?ngaySX_like=' + value);
  }
  searchDate2(value: string, value1: string): Observable<Detai[]> {
    return this.httpClient.get<Detai[]>(API_URL + '?ngaySX_like=' + value + '&ngayHetHan_like=' + value1);
  }
}
