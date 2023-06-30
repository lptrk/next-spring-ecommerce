import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { endpoints } from '../api/endpoints';
import { order } from 'src/app/types/order';

@Injectable({ providedIn: 'root' })
export class OrdersService {
  constructor(private http: HttpClient) {}
  allOrders: order[] = [];

  getAll() {
    return this.http
      .get<order[]>(`${environment.BASE_URL}/${endpoints.products}`)
      .subscribe((res) => {
        this.allOrders = res;
      });
  }

  getById(id: Number) {
    return this.http.get<order[]>(
      `${environment.BASE_URL}/${endpoints.products}/${id}`
    );
  }
}
