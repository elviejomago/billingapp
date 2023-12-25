import { HttpResponse } from '@angular/common/http';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { Account } from 'app/core/auth/account.model';
import { AccountService } from 'app/core/auth/account.service';
import { ICustomer } from 'app/entities/customer.model';
import { IInvoice } from 'app/entities/invoice.model';
import { IInvoiceProduct } from 'app/entities/invoiceProduct.model';
import { IProduct } from 'app/entities/product.model';
import { ISupplier } from 'app/entities/supplier.model';
import { CustomerService } from 'app/services/customer.service';
import { InvoiceService } from 'app/services/invoice.service';
import { ProductService } from 'app/services/product.service';
import { SupplierService } from 'app/services/supplier.service';
import SharedModule from 'app/shared/shared.module';
import { Subject, takeUntil } from 'rxjs';

@Component({
  standalone: true,
  selector: 'jhi-billing',
  templateUrl: './billing.component.html',
  styleUrl: './billing.component.scss',
  imports: [SharedModule, RouterModule, ReactiveFormsModule],
})
export default class BillingComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  customerArray: Array<ICustomer>;
  supplierArray: Array<ISupplier>;
  productArray: Array<IProduct>;
  invoiceProductArray: Array<IInvoiceProduct>;
  invoice: IInvoice;

  private readonly destroy$ = new Subject<void>();

  billingForm: FormGroup = this.fb.group({
    customer: [null],
    supplier: [null],
  });

  constructor(
    private accountService: AccountService,
    private customerService: CustomerService,
    private supplierService: SupplierService,
    private productService: ProductService,
    private invoiceService: InvoiceService,
    private fb: FormBuilder,
    private router: Router,
  ) {
    this.customerArray = [];
    this.supplierArray = [];
    this.productArray = [];
    this.invoiceProductArray = [];
    this.invoice = {
      customer: null,
      supplier: null,
      iva: 0,
      total: 0,
      subtotal: 0,
      invoiceProductArray: null,
    };
  }

  ngOnInit(): void {
    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe(account => (this.account = account));

    this.loadCustomers();
    this.loadSuppliers();
    this.loadProducts();
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  addProduct(): void {
    this.invoiceProductArray.push({
      amount: 0,
      invoice: null,
      product: null,
      unitPrice: 0,
      totalPrice: 0,
    });
  }

  changeAmount(event: any, invoiceProduct: IInvoiceProduct): void {
    invoiceProduct.amount = event.target.valueAsNumber;
  }

  changeProduct(event: any, invoiceProduct: IInvoiceProduct): void {
    const product = this.productArray.find(el => el.id === Number(event.target.value));
    invoiceProduct.unitPrice = product ? product.price : 0;
    invoiceProduct.totalPrice = invoiceProduct.amount * invoiceProduct.unitPrice;
    invoiceProduct.product = product!;
    this.invoice.subtotal += invoiceProduct.totalPrice;
    this.invoice.iva = this.invoice.subtotal * 0.12;
    this.invoice.total = this.invoice.subtotal + this.invoice.iva;
  }

  registerBilling(): void {
    this.invoice.customer = this.billingForm.get('customer')?.value;
    this.invoice.supplier = this.billingForm.get('supplier')?.value;
    this.invoice.invoiceProductArray = this.invoiceProductArray;
    console.log('FACTURADO: ', this.invoice);
    this.invoiceService.registerBilling(this.invoice).subscribe({
      next: (res: HttpResponse<Array<IInvoice>>) => {
        this.router.navigate(['']);
        alert('Factura Registrada');
      },
      error: e => console.error(e),
    });
  }

  private loadCustomers(): void {
    this.customerService.getAll().subscribe({
      next: (res: HttpResponse<Array<ICustomer>>) => {
        this.customerArray = res.body!;
      },
      error: e => console.error(e),
    });
  }

  private loadSuppliers(): void {
    this.supplierService.getAll().subscribe({
      next: (res: HttpResponse<Array<ISupplier>>) => {
        this.supplierArray = res.body!;
      },
      error: e => console.error(e),
    });
  }

  private loadProducts(): void {
    this.productService.getAll().subscribe({
      next: (res: HttpResponse<Array<IProduct>>) => {
        this.productArray = res.body!;
      },
      error: e => console.error(e),
    });
  }
}
