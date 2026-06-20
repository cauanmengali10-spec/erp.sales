package com.mengalisystems.erp.sales.itemVendido.domain;

import com.mengalisystems.erp.sales.itemVendido.dto.ItemVendidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class ItemVendaMapper {

    @Mappings({
            @Mapping(target = "nomeProduto", source = "produto.nome"),
            @Mapping(target = "idVenda", source = "venda.idVenda")
    })
    public abstract ItemVendidoResponse toDTO(ItemVendido itemVendido);


}
