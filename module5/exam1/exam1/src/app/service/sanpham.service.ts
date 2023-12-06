import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SanPham} from '../model/sanpham';
const API_URL = 'http://localhost:3000/sanpham';
@Injectable({
  providedIn: 'root'
})
export class SanphamService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>(API_URL);
  }
  findByIdSP(id: number): Observable<SanPham> {
    return this.httpClient.get<SanPham>(API_URL + '/' + id);
  }
  updateSP(id: number, sp: SanPham): Observable<SanPham> {
    return this.httpClient.put<SanPham>(API_URL + '/' + id, sp);
  }
  deleteSP(id: number): Observable<SanPham> {
    return this.httpClient.delete<SanPham>(API_URL + '/' + id);
  }
  createSP(sp: SanPham): Observable<SanPham> {
    return this.httpClient.post<SanPham>(API_URL, sp);
  }
  searchName(value: string): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>(API_URL + '?ten_like=' + value);
  }
  searchDate(value: string): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>(API_URL + '?ngaySX_like=' + value);
  }
  searchDate2(value: string, value1: string): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>(API_URL + '?ngaySX_like=' + value + '&ngayHetHan_like=' + value1);
  }
}
