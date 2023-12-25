package com.billing.service.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
}
