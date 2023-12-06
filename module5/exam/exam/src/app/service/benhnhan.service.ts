import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BenhNhan} from "../model/benhNhan";
const API_URL = 'http://localhost:3000/benhNhan';
@Injectable({
  providedIn: 'root'
})
export class BenhnhanService {

  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<BenhNhan[]> {
    return this.httpClient.get<BenhNhan[]>(API_URL);
  }
  findByIdBenhNhan(id: number): Observable<BenhNhan> {
    return this.httpClient.get<BenhNhan>(API_URL + '/' + id);
  }
  updateBenhNhan(id: number, benhNhan: BenhNhan): Observable<BenhNhan> {
    return this.httpClient.put<BenhNhan>(API_URL + '/' + id, benhNhan);
  }
  deleteBenhNhan(id: number): Observable<BenhNhan> {
    return this.httpClient.delete<BenhNhan>(API_URL + '/' + id);
  }
  createBenhNhan(benhNhan: BenhNhan): Observable<BenhNhan> {
    return this.httpClient.post<BenhNhan>(API_URL, benhNhan);
  }
}
