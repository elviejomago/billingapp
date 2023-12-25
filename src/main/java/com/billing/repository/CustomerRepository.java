package com.billing.repository;

import com.billing.domain.Customer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data R2DBC repository for the {@link Customer} entity.
 */
@Repository
public interface CustomerRepository extends R2dbcRepository<Customer, Long> {}
