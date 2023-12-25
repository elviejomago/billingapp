import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient, HttpResponse } from '@angular/common/http';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { ICustomer } from 'app/entities/customer.model';
import { IInvoice } from 'app/entities/invoice.model';

@Injectable({ providedIn: 'root' })
export class InvoiceService {
  private resourceUrl = this.applicationConfigService.getEndpointFor('api/invoice');

  constructor(
    private http: HttpClient,
    private applicationConfigService: ApplicationConfigService,
  ) {}

  registerBilling(invoice: IInvoice): Observable<HttpResponse<Array<IInvoice>>> {
    return this.http.post<Array<IInvoice>>(`${this.resourceUrl}/_save/register-billing`, invoice, { observe: 'response' });
  }
}
