package com.mengalisystems.erp.sales.venda.domain;


import com.mengalisystems.erp.sales.cliente.domain.Cliente;
import com.mengalisystems.erp.sales.itemVendido.domain.ItemVendido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venda")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    private LocalDateTime dataVenda;
    private BigDecimal valortotal;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVendido> itens;

}
