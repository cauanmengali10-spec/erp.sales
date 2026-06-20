package com.mengalisystems.erp.sales.venda.domain;

import com.mengalisystems.erp.sales.venda.dto.VendaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class VendaMapper {

    @Mappings({
            @Mapping(target = "cliente", source = "cliente.nome")
    })
    public abstract VendaResponse toDTO(Venda venda);

}
