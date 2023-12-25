package com.billing.service.dto;

import java.io.Serializable;
import java.util.List;
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
public class InvoiceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private SupplierDTO supplier;
    private CustomerDTO customer;
    private Double subtotal;
    private Double total;
    private Double iva;
    private List<InvoiceProductDTO> invoiceProductArray;
}
