package com.billing.service.impl;

import com.billing.repository.ProductRepository;
import com.billing.service.ProductService;
import com.billing.service.dto.ProductDTO;
import com.billing.service.mapper.ProductMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mono<List<ProductDTO>> getAll() {
        return productRepository.findAll().map(productMapper::toDto).collect(Collectors.toList());
    }
}
