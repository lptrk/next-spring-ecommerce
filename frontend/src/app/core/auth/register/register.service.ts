import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { registerUser } from 'src/app/types/registerUser';
import { token } from 'src/app/types/token';
import { endpoints } from '../../http/api/endpoints';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class RegisterService {
  constructor(private http: HttpClient, private router: Router) {}

  jwt: token | null = null;
  registerUser: registerUser = {
    firstName: '',
    lastName: '',
    userName: '',
    email: '',
    password: '',
    createdAt: new Date(),
    updatedAt: new Date(),
    token: '',
  };

  Register() {
    console.log(this.registerUser);
    this.http
      .post<registerUser>(
        `${environment.BASE_URL}/${endpoints.register}`,
        this.registerUser
      )
      .subscribe(
        (res) => {
          this.jwt = { token: res.token };
          alert('Registration successful! :)');
        },
        (error) => {
          console.error('Error occurred during registration: ', error);
        }
      );
  }
}
