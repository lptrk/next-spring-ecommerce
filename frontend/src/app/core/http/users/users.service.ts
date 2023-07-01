import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { endpoints } from '../api/endpoints';
import { registerUser } from 'src/app/types/registerUser';

@Injectable({ providedIn: 'root' })
export class UsersService {
  constructor(private http: HttpClient) {}
  allUsers: registerUser[] = [];

  getAll() {
    return this.http
      .get<registerUser[]>(`${environment.BASE_URL}/${endpoints.users}`)
      .subscribe((res) => {
        this.allUsers = res;
      });
  }

  getById(id: Number) {
    return this.http.get<registerUser[]>(
      `${environment.BASE_URL}/${endpoints.users}/${id}`
    );
  }

}
