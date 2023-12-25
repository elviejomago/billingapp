import { Routes } from '@angular/router';

import BillingComponent from './billing.component';

const billingRoute: Routes = [
  {
    path: '',
    component: BillingComponent,
    data: {
      defaultSort: 'id,asc',
    },
  },
];

export default billingRoute;
