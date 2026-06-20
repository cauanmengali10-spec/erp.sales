package com.mengalisystems.erp.sales.itemVendido.domain;


import com.mengalisystems.erp.sales.itemVendido.dto.ItemVendidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/itensVendidos")
public class ItemVendidoController {

    private final ItemVendidoService itemVendidoService;


    @GetMapping
    public List<ItemVendidoResponse>buscarItens(){
        return itemVendidoService.buscarItensVendidos();
    }
}
