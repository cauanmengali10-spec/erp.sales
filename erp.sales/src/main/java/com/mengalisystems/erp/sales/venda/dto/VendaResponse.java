package com.mengalisystems.erp.sales.venda.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class VendaResponse {

    private Long idVenda;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataVenda;
    private BigDecimal valortotal;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cliente;

}
