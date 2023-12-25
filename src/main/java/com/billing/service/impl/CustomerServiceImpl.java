package com.billing.service.impl;

import com.billing.repository.CustomerRepository;
import com.billing.service.CustomerService;
import com.billing.service.dto.CustomerDTO;
import com.billing.service.mapper.CustomerMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Mono<List<CustomerDTO>> getAll() {
        return customerRepository.findAll().map(customerMapper::toDto).collect(Collectors.toList());
    }
}
