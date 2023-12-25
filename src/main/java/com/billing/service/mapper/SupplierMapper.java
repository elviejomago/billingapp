package com.billing.service.mapper;

import com.billing.domain.Supplier;
import com.billing.service.dto.SupplierDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SupplierMapper extends EntityMapper<SupplierDTO, Supplier> {}
