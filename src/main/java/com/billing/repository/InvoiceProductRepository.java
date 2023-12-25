package com.billing.repository;

import com.billing.domain.InvoiceProduct;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data R2DBC repository for the {@link InvoiceProduct} entity.
 */
@Repository
public interface InvoiceProductRepository extends ReactiveCrudRepository<InvoiceProduct, Long> {}
