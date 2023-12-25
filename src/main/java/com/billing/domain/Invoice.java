package com.billing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "total")
    private Double total;

    @Column(name = "iva")
    private Double iva;
}
