import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { endpoints } from '../api/endpoints';
import { category } from 'src/app/types/category';

@Injectable({ providedIn: 'root' })
export class CategoriesSerivce {
  constructor(private http: HttpClient) {}
  allCategories: category[] = [];

  getAll() {
    return this.http
      .get<category[]>(`${environment.BASE_URL}/${endpoints.products}`)
      .subscribe((res) => {
        this.allCategories = res;
      });
  }

  getById(id: Number) {
    return this.http.get<category[]>(
      `${environment.BASE_URL}/${endpoints.products}/${id}`
    );
  }
}
