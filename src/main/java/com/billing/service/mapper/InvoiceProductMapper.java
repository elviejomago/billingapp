package com.billing.service.mapper;

import com.billing.domain.InvoiceProduct;
import com.billing.service.dto.InvoiceProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { InvoiceMapper.class, ProductMapper.class })
public interface InvoiceProductMapper extends EntityMapper<InvoiceProductDTO, InvoiceProduct> {}
