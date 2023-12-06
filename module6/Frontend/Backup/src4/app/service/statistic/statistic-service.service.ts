import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class StatisticServiceService {
    readonly API: string = 'http://localhost:8080/api/statistic';

    constructor(private httpClient: HttpClient) {
    }

    getAll(): Observable<string[]> {
        return this.httpClient.get<string[]>(`${this.API}/list/material1`);
    }

    getPdf(): Observable<Blob> {
        // @ts-ignore
        return this.httpClient.get<Blob>(`${this.API}/pdf`, {responseType: 'blob'});
    }

    searchStatisticMaterial(fromDate: string, toDate: string): Observable<string[]> {
        return this.httpClient.get<string[]>(`${this.API}/search/material` + '?fromDate=' + fromDate + '&toDate=' + toDate);
    }

    // searchStatisticMaterial(): Observable<string[]> {
    //   return this.httpClient.get
    // }

    // test chart material
    cryptoData(fromDate: string, toDate: string) {
        // tslint:disable-next-line:max-line-length
        return this.httpClient.get(`${this.API}/search/material` + '?fromDate=' + fromDate + '&toDate=' + toDate).toPromise().then((data) => {
            return data;
        });
    }

    cryptoData1() {
        return this.httpClient.get(`${this.API}/chart`).toPromise().then((data) => {
            return data;
        });
    }

    getAllCustomer(): Observable<string[]> {
        return this.httpClient.get<string[]>(this.API + '/list/customer');
    }

    // KimPBH-Thong ke tai chinh
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

    getPdfKim(search: string[]): Observable<Blob> {
        // @ts-ignore
        return this.httpClient.post<Blob>(`${this.API}/pdf2`, search, {responseType: 'blob'});
    }

    getPDF(): Observable<Blob> {
        // @ts-ignore
        return this.httpClient.get<Blob>(`${this.API}/pdf-huyen`, {responseType: 'blob'});
    }

    searchStatisticCustomer(fromMonth: string, toMonth: string, year: string): Observable<string[]> {
        // tslint:disable-next-line:max-line-length
        return this.httpClient.get<string[]>(`${this.API}/search/customer` + '?fromMonth=' + fromMonth + '&toMonth=' + toMonth + '&year=' + year);
    }

    cryptoDataHuyen(fromMonth: string, toMonth: string, year: string) {
        // tslint:disable-next-line:max-line-length
        return this.httpClient.get(`${this.API}/search/customer` + '?fromMonth=' + fromMonth + '&toMonth=' + toMonth + '&year=' + year).toPromise().then((data) => {
            return data;
        });
    }

    cryptoDataCustomer() {
        return this.httpClient.get(`${this.API}/list/customer`).toPromise().then((data) => {
            return data;
        });
    }

    // test chart financial
    cryptoDataKim() {
        return this.httpClient.get(`${this.API}/huyhang`).toPromise().then((data) => {
            return data;
        });
    }
}
