import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { token } from 'src/app/types/token';
import { RegisterService } from '../../auth/register/register.service';

@Injectable({ providedIn: 'root' })
export class JwtService {
  constructor(
    private http: HttpClient,
    private registerService: RegisterService
  ) {}

  jwt: token | null = this.registerService.jwt;

  authenticatedRequest(endpoint: string, storedData: any) {
    if (this.jwt && this.jwt.token) {
      // Construct the Authorization header with the token
      const headers = new HttpHeaders({
        Authorization: `Bearer ${this.jwt.token}`,
      });

      // Make the GET request with the token as an Authorization header
      this.http
        .get(`http://localhost:8080/api/v1/${endpoint}`, { headers })
        .subscribe(
          (data) => {
            console.log('Data with token:', data);
            storedData = data;
          },
          (error) => {
            console.error(
              'Error occurred during GET request with token:',
              error
            );
          }
        );
    } else {
      console.error('Token is not available.');
    }
  }
}
