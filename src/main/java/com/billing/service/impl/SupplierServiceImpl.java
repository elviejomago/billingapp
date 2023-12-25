package com.billing.service.impl;

import com.billing.repository.SupplierRepository;
import com.billing.service.SupplierService;
import com.billing.service.dto.SupplierDTO;
import com.billing.service.mapper.SupplierMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Mono<List<SupplierDTO>> getAll() {
        return supplierRepository.findAll().map(supplierMapper::toDto).collect(Collectors.toList());
    }
}
