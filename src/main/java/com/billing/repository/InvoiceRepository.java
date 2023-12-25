package com.billing.repository;

import com.billing.domain.Invoice;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data R2DBC repository for the {@link Invoice} entity.
 */
@Repository
public interface InvoiceRepository extends ReactiveCrudRepository<Invoice, Long> {}
