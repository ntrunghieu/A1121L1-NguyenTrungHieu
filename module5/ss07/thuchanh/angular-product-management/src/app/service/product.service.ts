import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
const
  API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];
  constructor(private _httpClient: HttpClient) { }
  getAll(page: number): Observable<Product[]> {
    return this._httpClient.get<Product[]>(API_URL + '/product' + '?_page=' + page + '&_limit=3&_sort=price&_order=asc');
  }

  save(value: Product): Observable<Product> {
    return this._httpClient.post<Product>(API_URL + '/product', value);
  }

  findById(id): Observable<Product> {
    return this._httpClient.get<Product>(API_URL + '/product' + '/' + id);
  }

  update(id: number, product1: Product): Observable<Product> {
    return this._httpClient.put<Product>(API_URL + '/product' + '/' + id, product1);
  }

  delete(id: number): Observable<Product> {
    return this._httpClient.delete<Product>(API_URL + '/product/' + id);
  }
  search(value1: string, value2: string): Observable<Product[]> {
    return this._httpClient.get<Product[]>(API_URL + '/product' + '?name_like=' + value1 + '&price_like=' + value2);
  }
  // sort():Observable<IProduct[]>{
  //   return this._httpClient.get<IProduct[]>(API_URL +'/product' +'?_sort=price&_order=asc');
  // }
  // add(value: Product) {
  //   this.products.push(value);
  // }
  // findById(id: number) {
  //   for (let i: number = 0; i < this.products.length; i++ ) {
  //     if (this.products[i].id == id) {
  //       return this.products[i];
  //     }
  //   }
  //   return undefined;
  // }
  //
  // update(product1: Product) {
  //   for (let i:number = 0; i < this.products.length; i++) {
  //     if (this.products[i].id === product1.id){
  //       this.products[i] = product1;
  //     }
  //   }
  // }
  //
  // delete(id: number) {
  //   for (let i:number = 0;i < this.products.length; i++) {
  //     if (this.products[i].id == id) {
  //       for (let j = i; j < this.products.length; j++) {
  //         this.products[j] = this.products[j + 1];
  //       }
  //       this.products.pop();
  //     }
  //   }
  // }
  // getAll() {
  //   return this.products;
  // }
  //
  // saveProduct(product: Product) {
  //   this.products.push(product);
  // }
}
