package com.mengalisystems.erp.sales.produto.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoPostRequest {

    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private boolean ativo;



}
