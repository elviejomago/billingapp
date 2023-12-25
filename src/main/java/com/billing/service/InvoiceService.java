package com.billing.service;

import com.billing.domain.Invoice;
import com.billing.service.dto.InvoiceDTO;
import reactor.core.publisher.Mono;

public interface InvoiceService {
    Mono<Invoice> registerBilling(InvoiceDTO invoice);
}
