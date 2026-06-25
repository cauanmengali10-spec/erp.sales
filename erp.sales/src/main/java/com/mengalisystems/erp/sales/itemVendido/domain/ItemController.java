package com.mengalisystems.erp.sales.itemVendido.domain;


import com.mengalisystems.erp.sales.itemVendido.dto.ItemVendidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itens")
public class ItemController {

    private final ItemVendidoService itemVendidoService;


    @GetMapping
    public List<ItemVendidoResponse>itensVendidos(){
        return itemVendidoService.buscarItensVendidos();
    }
}
