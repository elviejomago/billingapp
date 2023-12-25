package com.billing.service.impl;

import com.billing.domain.Invoice;
import com.billing.domain.InvoiceProduct;
import com.billing.repository.InvoiceProductRepository;
import com.billing.repository.InvoiceRepository;
import com.billing.service.InvoiceService;
import com.billing.service.dto.InvoiceDTO;
import com.billing.service.mapper.InvoiceProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceProductRepository invoiceProductRepository;

    @Autowired
    private InvoiceProductMapper invoiceProductMapper;

    @Override
    public Mono<Invoice> registerBilling(InvoiceDTO invoice) {
        Mono<Invoice> invoiceSaved = invoiceRepository.save(
            Invoice
                .builder()
                .customerId(invoice.getCustomer().getId())
                .supplierId(invoice.getSupplier().getId())
                .subtotal(invoice.getSubtotal())
                .total(invoice.getTotal())
                .iva(invoice.getIva())
                .build()
        );
        invoiceSaved.subscribe(el -> {
            invoice
                .getInvoiceProductArray()
                .forEach(ip -> {
                    InvoiceProduct invoiceProduct = invoiceProductMapper.toEntity(ip);
                    invoiceProduct.setInvoice(el);
                    invoiceProductRepository.save(invoiceProduct);
                });
        });
        return invoiceSaved;
    }
}
