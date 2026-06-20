package com.mengalisystems.erp.sales.produto.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoPutRequest {

    private Long idProduto;
    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private boolean ativo;

}
