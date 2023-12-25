package com.billing.service.mapper;

import com.billing.domain.Product;
import com.billing.service.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {}
