import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';
const API_URL = 'http://localhost:3000/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {
  constructor(private _httpClient: HttpClient) {
  }

  getAll(): Observable<Category[]> {
    return this._httpClient.get<Category[]>(`${API_URL}`);
  }

  getCategoryByID(id): Observable<Category> {
    return this._httpClient.get<Category>(`${API_URL}/${id}`);
  }
}
