import { ICustomer } from './customer.model';
import { IInvoice } from './invoice.model';
import { IProduct } from './product.model';
import { ISupplier } from './supplier.model';

export interface IInvoiceProduct {
  id?: number;
  amount: number;
  unitPrice: number;
  totalPrice: number;
  invoice: IInvoice | null;
  product: IProduct | null;
}
