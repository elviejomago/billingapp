package com.billing.web.rest;

import com.billing.security.AuthoritiesConstants;
import com.billing.service.ProductService;
import com.billing.service.dto.ProductDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    @GetMapping("/product/_get/all")
    public Mono<List<ProductDTO>> getAll() {
        return productService.getAll().switchIfEmpty(Mono.error(new RuntimeException("Error al obtener los datos")));
    }
}
