package com.mengalisystems.erp.sales.itemVendido.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendidoRequest {

    private Long idProduto;
    private Integer quantidade;
}
