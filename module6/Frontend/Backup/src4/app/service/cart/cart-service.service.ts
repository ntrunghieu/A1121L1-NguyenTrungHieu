import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ICartMaterial} from '../../model/cart/icart-material';
import {ProvinceCity} from '../../model/cart/provinceCity';
import {District} from '../../model/cart/district';
import {Wards} from '../../model/cart/wards';
import {ICustomer} from '../../model/customer/icustomer';
import {IMaterial} from '../../model/material/imaterial';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {
  private URL_API_CART_MATERIAL = 'http://localhost:8080/api/cart';
  // tslint:disable-next-line:max-line-length
  private URL_API_LIST_PROVINCE_CITY = 'https://provinces.open-api.vn/api/?depth=3&fbclid=IwAR37WY83cG5DqMTujAm4HCcSpq2Xwji4dieEFcnLnlyM7QNOiG658bnLiVM';
  private URL_API_PROVINCE_CITY = 'https://provinces.open-api.vn/api/p';
  private URL_API_DISTRICT = 'https://provinces.open-api.vn/api/d';
  private URL_API_WARD = 'https://provinces.open-api.vn/api/w';

  constructor(private httpClient: HttpClient) { }

  getAllProvinceCity(): Observable<ProvinceCity[]> {
    const url = `${this.URL_API_LIST_PROVINCE_CITY}`;
    return this.httpClient.get<ProvinceCity[]>(url);
  }

  getProvinceCity(code: number): Observable<ProvinceCity> {
    const url = `${this.URL_API_PROVINCE_CITY}/${code}?depth=2`;
    return this.httpClient.get<ProvinceCity>(url);
  }

  getDistrict(code: number): Observable<District> {
    const url = `${this.URL_API_DISTRICT}/${code}?depth=2`;
    return this.httpClient.get<District>(url);
  }

  getWards(code: number): Observable<Wards> {
    const url = `${this.URL_API_WARD}/${code}?depth=2`;
    return this.httpClient.get<Wards>(url);
  }

  getAllCart(): Observable<ICartMaterial[]> {
    return this.httpClient.get<ICartMaterial[]>(`${this.URL_API_CART_MATERIAL}/list`);
  }

  updateQuantity(quantity: number, money: number, id: number): Observable<void> {
    const url = `${this.URL_API_CART_MATERIAL}/update?` + `quantity=${quantity}&money=${money}&id=${id}`;
    return this.httpClient.get<void>(url);
  }

  deleteCart(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.URL_API_CART_MATERIAL}/delete/${id}`);
  }
  deleteCart2(id: number[]): Observable<number[]> {
    return this.httpClient.post<number[]>(`${this.URL_API_CART_MATERIAL}/delete`, id );
  }
  checkCartPayment(id: number[]): Observable<ICartMaterial[]> {
    return this.httpClient.post<ICartMaterial[]>(`${this.URL_API_CART_MATERIAL}/checkCart`, id );
  }

  insertCart(customer: ICustomer, id: number[]): Observable<void> {
    return this.httpClient.post<void>(`${this.URL_API_CART_MATERIAL}/insert/${id}`, customer);
  }

  getPdf(id: number[]): Observable<Blob> {
    // @ts-ignore
    return this.httpClient.post<Blob>(`${this.URL_API_CART_MATERIAL}/pdf`, id, {responseType: 'blob'} );
  }

  addMaterialCart(iMaterial: IMaterial): Observable<void> {
    // @ts-ignore
    return this.httpClient.post<void>(`${this.URL_API_CART_MATERIAL}/addMaterialCart`, iMaterial);
  }
}
