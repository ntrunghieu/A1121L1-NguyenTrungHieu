import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {BenhNhan} from "../model/benhNhan";
import {HttpClient} from "@angular/common/http";
import {LoHang} from "../loHang";
import {SanPham} from "../sanPham";
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
}
