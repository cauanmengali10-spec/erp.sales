package com.mengalisystems.erp.sales.itemVendido.domain;

import com.mengalisystems.erp.sales.produto.domain.Produto;
import com.mengalisystems.erp.sales.venda.domain.Venda;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "itens_vendidos")
public class ItemVendido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


}
