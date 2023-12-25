package com.billing.service.mapper;

import com.billing.domain.Invoice;
import com.billing.service.dto.InvoiceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { SupplierMapper.class, CustomerMapper.class })
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {}
