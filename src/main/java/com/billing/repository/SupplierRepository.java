package com.billing.repository;

import com.billing.domain.Supplier;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data R2DBC repository for the {@link Supplier} entity.
 */
@Repository
public interface SupplierRepository extends R2dbcRepository<Supplier, Long> {}
