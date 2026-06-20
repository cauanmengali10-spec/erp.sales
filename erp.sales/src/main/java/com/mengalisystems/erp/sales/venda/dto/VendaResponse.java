package com.mengalisystems.erp.sales.venda.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/aa HH:mm:ss")
    private LocalDateTime dataVenda;
    private BigDecimal valortotal;
    private String cliente;

}
