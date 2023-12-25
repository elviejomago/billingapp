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
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String ident;
}
