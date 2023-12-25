package com.billing.web.rest;

import com.billing.security.AuthoritiesConstants;
import com.billing.service.SupplierService;
import com.billing.service.dto.SupplierDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;

    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    @GetMapping("/supplier/_get/all")
    public Mono<List<SupplierDTO>> getAll() {
        return supplierService.getAll().switchIfEmpty(Mono.error(new RuntimeException("Error al obtener los datos")));
    }
}
