import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient, HttpResponse } from '@angular/common/http';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { IProduct } from 'app/entities/product.model';

@Injectable({ providedIn: 'root' })
export class ProductService {
  private resourceUrl = this.applicationConfigService.getEndpointFor('api/product');

  constructor(
    private http: HttpClient,
    private applicationConfigService: ApplicationConfigService,
  ) {}

  getAll(): Observable<HttpResponse<Array<IProduct>>> {
    return this.http.get<Array<IProduct>>(`${this.resourceUrl}/_get/all`, { observe: 'response' });
  }
}
