package com.mengalisystems.erp.sales.cliente.domain;


import com.mengalisystems.erp.sales.cliente.dto.ClientePostRequest;
import com.mengalisystems.erp.sales.cliente.dto.ClientePutRequest;
import com.mengalisystems.erp.sales.cliente.dto.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public abstract Cliente toCliente(ClientePostRequest clientePostRequest);

    public abstract void replaceFromDTO(ClientePutRequest clientePutRequest, @MappingTarget Cliente cliente);

    public abstract ClienteResponse toDTO(Cliente cliente);


}
