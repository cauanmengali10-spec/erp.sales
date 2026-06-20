package com.mengalisystems.erp.sales.itemVendido.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ItemVendidoResponse {

    private Long idItem;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
    private String nomeProduto;
    private Long idVenda;

}
