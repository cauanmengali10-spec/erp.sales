package com.mengalisystems.erp.sales.venda.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mengalisystems.erp.sales.itemVendido.dto.ItemVendidoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cpfCliente;
    private List<ItemVendidoRequest>itens;
}
