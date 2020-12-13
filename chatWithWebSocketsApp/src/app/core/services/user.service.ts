import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user.models';
import {tap} from 'rxjs/operators';
@Injectable({
    providedIn: 'root'
  })
export class UserService {
    userRoute = `${environment.api}/user`;
    constructor(private http: HttpClient) {}

    public getAll(): Observable<Array<User>> {
        return this.stringifyData(this.http.get<Array<User>> (`${this.userRoute}`));
    }

    public getById(id: number): Observable<User> {
        return this.stringifyData(this.http.get<User>(`${this.userRoute}/${id}`));
    }

    public login(user: User): Observable<User> {
        return this.stringifyData(this.http.post<User>(`${this.userRoute}/login`, user));
    }

    public save(user: User): Observable<User> {
        return this.http.post<User>(`${this.userRoute}`, user)
        .pipe(tap(res => JSON.stringify(res)));
    }

    public update(user:User, id: number): Observable<User> {
        return this.stringifyData(this.http.put<User>(`${this.userRoute}/${id}`, user));
    }

    public deleteById(id: number): Observable<User> {
        return this.stringifyData(this.http.delete<User>(`${this.userRoute}/${id}`));
    }

    public stringifyData(data) {
        return data.pipe(tap(res=>JSON.stringify(res)));
    }


}