package com.billing.web.rest;

import com.billing.security.AuthoritiesConstants;
import com.billing.service.CustomerService;
import com.billing.service.dto.CustomerDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    @GetMapping("/customer/_get/all")
    public Mono<List<CustomerDTO>> getAll() {
        return customerService.getAll().switchIfEmpty(Mono.error(new RuntimeException("Error al obtener los datos")));
    }
}
