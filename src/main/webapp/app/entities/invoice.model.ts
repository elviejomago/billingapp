import { ICustomer } from './customer.model';
import { IInvoiceProduct } from './invoiceProduct.model';
import { ISupplier } from './supplier.model';

export interface IInvoice {
  id?: number;
  subtotal: number;
  total: number;
  iva: number;
  customer: ICustomer | null;
  supplier: ISupplier | null;
  invoiceProductArray: Array<IInvoiceProduct> | null;
}
