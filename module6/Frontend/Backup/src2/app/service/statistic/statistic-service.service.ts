import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class StatisticServiceService {
  readonly API: string = 'http://localhost:8080/api/statistic';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<string[]> {
    return this.httpClient.get<string[]>(this.API + '/list/material');
  }

  getPdf(): Observable<Blob> {
    // @ts-ignore
    return this.httpClient.get<Blob>(`${this.API}/pdf`, {responseType: 'blob'});
  }

  // searchStatisticMaterial(): Observable<string[]> {
  //   return this.httpClient.get
  // }


  // getBan(): Observable<number> {
  //   return this.http.get<number>(`${this.API_URL}/banhang`);
  // }
  //
  // getTra(): Observable<number> {
  //   return this.http.get<number>(`${this.API_URL}/trahang`);
  // }
  //
  // getHuy(): Observable<number> {
  //   return this.http.get<number>(`${this.API_URL}/huyhang`);
  // }
  //
  // getLuong(): Observable<number> {
  //   return this.http.get<number>(`${this.API_URL}/luongNV`);
  // }
  //
  // getNhap(): Observable<number> {
  //   return this.http.get<number>(`${this.API_URL}/nhaphang`);
  // }

  search(month: string, year: string): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.API}/search?` + `month=${month}&year=${year}`);
  }

  getPdf2(search: string[]): Observable<Blob> {
    // @ts-ignore
    return this.httpClient.post<Blob>(`${this.API}/pdf2`, search, {responseType: 'blob'});
  }


  getAllCustomer(page: number): Observable<string[]> {
    return this.httpClient.get<string[]>(this.API + '/list/customer?page=' + page);
  }

  getPDF(): Observable<Blob> {
    // @ts-ignore
    return this.httpClient.get<Blob>(`${this.API}/pdf-huyen`, {responseType: 'blob'});
  }

  searchStatisticCustomer(fromMonth: string, toMonth: string, year: string): Observable<string[]> {
    console.log(fromMonth);
    return this.httpClient.get<string[]>(`${this.API}/search/customer` + '?fromMonth=' + fromMonth + '&toMonth=' + toMonth + '&year=' + year);
  }
}

