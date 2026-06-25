package com.mengalisystems.erp.sales.venda.domain;

import com.mengalisystems.erp.sales.cliente.domain.Cliente;
import com.mengalisystems.erp.sales.cliente.domain.ClienteRepository;
import com.mengalisystems.erp.sales.handler.APIException;
import com.mengalisystems.erp.sales.itemVendido.domain.ItemVendido;
import com.mengalisystems.erp.sales.itemVendido.dto.ItemVendidoRequest;
import com.mengalisystems.erp.sales.produto.domain.Produto;
import com.mengalisystems.erp.sales.produto.domain.ProdutoRepository;
import com.mengalisystems.erp.sales.venda.dto.VendaRequest;
import com.mengalisystems.erp.sales.venda.dto.VendaResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.rmi.server.UID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VendaService {

    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final VendaMapper vendaMapper;
    private final VendaRepository vendaRepository;

    public List<VendaResponse>buscarVendas(){
        return vendaRepository.findAll()
                .stream()
                .map(vendaMapper::toDTO)
                .toList();
    }

    public VendaResponse salvar(VendaRequest vendaRequest) {

        Cliente cliente = null;
        if (vendaRequest.getCpfCliente() != null){
            cliente = clienteRepository.findByCpf(vendaRequest.getCpfCliente())
                    .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        }

        Venda venda = Venda.builder()
                .cliente(cliente)
                .dataVenda(LocalDateTime.now())
                .build();

        List<ItemVendido> itensVendidos = new ArrayList<>();
        BigDecimal valortotal = BigDecimal.ZERO;

        for (ItemVendidoRequest itens : vendaRequest.getItens()) {
            Produto produto = produtoRepository.findById(itens.getIdProduto())
                    .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado"));

            if (produto.getEstoque() < itens.getQuantidade()) {
                throw APIException.build(HttpStatus.NOT_FOUND, "Estoque insuficiente");
            }
            BigDecimal subtotal = produto.getPreco()
                    .multiply(BigDecimal.valueOf(itens.getQuantidade()));

            ItemVendido itemVendido = ItemVendido.builder()
                    .venda(venda)
                    .produto(produto)
                    .quantidade(itens.getQuantidade())
                    .precoUnitario(produto.getPreco())
                    .subtotal(subtotal)
                    .build();

            produto.setEstoque(produto.getEstoque() - itens.getQuantidade());

            itensVendidos.add(itemVendido);
            valortotal = valortotal.add(subtotal);
        }

        venda.setItens(itensVendidos);
        venda.setValortotal(valortotal);

        Venda vendaSalva = vendaRepository.save(venda);
        return vendaMapper.toDTO(vendaSalva);

    }





}
