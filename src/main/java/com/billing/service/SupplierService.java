package com.billing.service;

import com.billing.service.dto.SupplierDTO;
import java.util.List;
import reactor.core.publisher.Mono;

public interface SupplierService {
    Mono<List<SupplierDTO>> getAll();
}
