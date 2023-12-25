import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient, HttpResponse } from '@angular/common/http';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { ISupplier } from 'app/entities/supplier.model';

@Injectable({ providedIn: 'root' })
export class SupplierService {
  private resourceUrl = this.applicationConfigService.getEndpointFor('api/supplier');

  constructor(
    private http: HttpClient,
    private applicationConfigService: ApplicationConfigService,
  ) {}

  getAll(): Observable<HttpResponse<ISupplier[]>> {
    return this.http.get<ISupplier[]>(`${this.resourceUrl}/_get/all`, { observe: 'response' });
  }
}
