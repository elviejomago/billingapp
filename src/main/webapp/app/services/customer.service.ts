import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient, HttpResponse } from '@angular/common/http';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { ICustomer } from 'app/entities/customer.model';

@Injectable({ providedIn: 'root' })
export class CustomerService {
  private resourceUrl = this.applicationConfigService.getEndpointFor('api/customer');

  constructor(
    private http: HttpClient,
    private applicationConfigService: ApplicationConfigService,
  ) {}

  getAll(): Observable<HttpResponse<Array<ICustomer>>> {
    return this.http.get<Array<ICustomer>>(`${this.resourceUrl}/_get/all`, { observe: 'response' });
  }
}
