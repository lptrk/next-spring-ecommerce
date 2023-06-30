import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { endpoints } from '../api/endpoints';
import { product } from 'src/app/types/product';

@Injectable({ providedIn: 'root' })
export class ProductsService {
  constructor(private http: HttpClient) {}
  allProducts: product[] = [];

  getAll() {
    return this.http
      .get<product[]>(`${environment.BASE_URL}/${endpoints.products}`)
      .subscribe((res) => {
        this.allProducts = res;
      });
  }

  getById(id: Number) {
    return this.http.get<product[]>(
      `${environment.BASE_URL}/${endpoints.products}/${id}`
    );
  }
}
