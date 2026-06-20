package com.mengalisystems.erp.sales.itemVendido.domain;


import com.mengalisystems.erp.sales.itemVendido.dto.ItemVendidoResponse;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ItemVendidoService {

    private final ItemVendidoRepository itemVendidoRepository;
    private final ItemVendaMapper itemVendaMapper;


    public List<ItemVendidoResponse>buscarItensVendidos(){
        return itemVendidoRepository.findAll()
                .stream()
                .map(itemVendaMapper::toDTO)
                .toList();
    }

}
