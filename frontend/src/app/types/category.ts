import { product } from './product';

export interface category {
  id: number;
  name: string;
  description: string;
  createdAt: Date;
  updatedAt: Date;
  products: product[];
}
