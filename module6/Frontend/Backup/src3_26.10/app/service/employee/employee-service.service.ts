import {Injectable} from '@angular/core';
import {IEmployee} from '../../model/employee/iemployee';
import {Observable, throwError} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {IPositionEmployee} from '../../model/employee/iposition-employee';


@Injectable({
    providedIn: 'root'
})
export class EmployeeServiceService {
    API_URL = 'http://localhost:8080/api/employee';

    constructor(private http: HttpClient) {
    }

    // NhiVP lay employee theo code
    getEmployeeByCode(code: string): Observable<IEmployee> {
        return this.http.get<IEmployee>(this.API_URL + '/byCode/' + code);
    }

    // NhiVP lay ds chuc vu tru chuc vu quan ly
    getPositionNotManager(): Observable<IPositionEmployee[]> {
        return this.http.get<IPositionEmployee[]>(this.API_URL + '/position-NotManager/list');
    }

    // NhiVP lay danh sach ma nhan vien da co tai khoan theo list string
    getAllEmployeeHasAccount(): Observable<string[]> {
        return this.http.get<string[]>(this.API_URL + '/listHasAccount');
    }

    // AnDVH findEmployee by ID
    findEmployeeById(id: number): Observable<IEmployee> {
        return this.http.get<IEmployee>(this.API_URL + '/detail/' + id);
    }

    // AnDVH find employee by AccountId
    public findEmployeeByAccountId(accountId: number): Observable<IEmployee> {
        return this.http.get<IEmployee>(`${this.API_URL}/getEmployeeByAccount/${accountId}`);
    }

// AnDVH update employee
    public updateEmployee(id: number, employee: IEmployee): Observable<void> {
        return this.http.patch<void>(`${this.API_URL}/update/${id}`, employee);
    }

    getAllEmployee(): Observable<IEmployee[]> {
        return this.http.get<IEmployee[]>(this.API_URL);
    }

    getAllEmployeeWithPagination(page: number): Observable<IEmployee[]> {
        return this.http.get<IEmployee[]>(this.API_URL + '/employee-pagination/' + page);
    }


    deleteEmployeeById(id: number): Observable<IEmployee> {
        console.log('ID de xoa: ' + id);
        return this.http.delete<IEmployee>(this.API_URL + '/employee-delete/' + id);
    }

    // findEmployeeById(code: string): Observable<IEmployee> {
    //   return this.http.get<IEmployee>(`${this.API_URL}/${code}`);
    // }

    searchEmployeeByName(value: string): Observable<IEmployee[]> {
        return this.http.get<IEmployee[]>(this.API_URL + `/customer-search?name=${value}}`);
    }

    // NhiVP lay danh sach ma nhan vien chua co tai khoan theo list string
    getAllEmployeeDontHasAccount(): Observable<string[]> {
        return this.http.get<string[]>(this.API_URL + '/listDontHasAccount');
    }

    // NhiVP lay danh sach so dien thoai
    getAllPhone(): Observable<string[]> {
        return this.http.get<string[]>(this.API_URL + '/list-Phone');
    }

    saveEmployee(employee: IEmployee): Observable<void> {
        return this.http.post<void>(this.API_URL + '/create', employee);
    }

    getListPosition(): Observable<any> {
        return this.http.get(this.API_URL + '/position/list');
    }

    adminUpdateEmployee(employee: IEmployee): Observable<IEmployee> {
        return this.http.patch<IEmployee>(this.API_URL + '/update/' + employee.employeeId, employee);
    }
}

