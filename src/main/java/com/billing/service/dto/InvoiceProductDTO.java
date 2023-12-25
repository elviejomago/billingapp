package com.billing.service.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class InvoiceProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private InvoiceDTO invoice;
    private ProductDTO product;
    private Integer amount;
    private Double unitPrice;
    private Double totalPrice;
}
