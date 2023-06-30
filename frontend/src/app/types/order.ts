import { registerUser } from './registerUser';

export interface order {
  id: string;
  user: registerUser;
  orderDate: Date;
  totalAmount: number;
  status: string;
  shippingAddress: string;
  createdAt: Date;
  updatedAt: Date;
}
