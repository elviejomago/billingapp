package com.billing.repository;

import com.billing.domain.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data R2DBC repository for the {@link Product} entity.
 */
@Repository
public interface ProductRepository extends R2dbcRepository<Product, Long> {}
