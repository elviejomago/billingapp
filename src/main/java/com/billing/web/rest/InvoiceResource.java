package com.billing.web.rest;

import com.billing.domain.Invoice;
import com.billing.security.AuthoritiesConstants;
import com.billing.service.InvoiceService;
import com.billing.service.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class InvoiceResource {

    @Autowired
    private InvoiceService invoiceService;

    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    @PostMapping("/invoice/_save/register-billing")
    public Mono<Invoice> registerBilling(@RequestBody InvoiceDTO invoice) {
        System.err.println("eeeeee " + invoice);
        return invoiceService.registerBilling(invoice);
    }
}
