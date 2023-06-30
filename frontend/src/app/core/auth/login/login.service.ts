import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { loginUser } from 'src/app/types/loginUser';
import { token } from 'src/app/types/token';
import { environment } from 'src/environments/environment';
import { endpoints } from 'src/app/core/http/api/paths';
@Injectable({ providedIn: 'root' })
export class LoginService {
  constructor(private http: HttpClient, private router: Router) {}
  jwt: token | null = null;

  loginUser: loginUser = {
    email: '',
    password: '',
    token: '',
  };

  Login() {
    this.http
      .post<loginUser>(
        `${environment.BASE_URL}/${endpoints.login}`,
        this.loginUser
      )
      .subscribe(
        (res) => {
          this.jwt = { token: res.token };
          alert('Login successfull! :)');
        },
        (error) => {
          console.error('Error occured during Login: ', error);
        }
      );
  }
}
