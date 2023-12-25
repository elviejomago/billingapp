package com.billing.service;

import com.billing.service.dto.ProductDTO;
import java.util.List;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<List<ProductDTO>> getAll();
}
