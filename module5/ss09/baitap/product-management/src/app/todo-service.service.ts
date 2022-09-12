import { Injectable } from '@angular/core';
import {Todo} from './todo';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class TodoServiceService {
  constructor(private _httpClient : HttpClient) { }
  getAll(): Observable<Todo[]> {
    return this._httpClient.get<Todo[]>(API_URL + '/todo');
  }
  save(todo: Todo): Observable<Todo> {
    return this._httpClient.post<Todo>(API_URL + '/todo', todo);
  }
  getById(id): Observable<Todo> {
    return this._httpClient.get<Todo>(API_URL + '/todo' + '/' + id);
  }
  update(id: number , todo: Todo): Observable<Todo> {
    return this._httpClient.put<Todo>(API_URL + '/todo' + '/' + id, todo);
  }
  delete(id: number): Observable<Todo> {
    return this._httpClient.delete<Todo>(API_URL + '/todo' + '/' + id);
  }
}
