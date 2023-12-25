package com.billing.service.mapper;

import com.billing.domain.Customer;
import com.billing.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {}
