package com.billing.service;

import com.billing.service.dto.CustomerDTO;
import java.util.List;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<List<CustomerDTO>> getAll();
}
