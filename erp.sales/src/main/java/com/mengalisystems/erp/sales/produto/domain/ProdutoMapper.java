package com.mengalisystems.erp.sales.produto.domain;

import com.mengalisystems.erp.sales.cliente.dto.ClientePostRequest;
import com.mengalisystems.erp.sales.produto.dto.ProdutoPostRequest;
import com.mengalisystems.erp.sales.produto.dto.ProdutoPutRequest;
import com.mengalisystems.erp.sales.produto.dto.ProdutoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ProdutoMapper {

    public abstract Produto toProduto(ProdutoPostRequest produtoPostRequest);

    public abstract void replaceFromDTO(ProdutoPutRequest produtoPutRequest, @MappingTarget Produto produto);

    public abstract ProdutoResponse toDTO(Produto produto);



}
