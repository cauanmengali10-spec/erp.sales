package com.mengalisystems.erp.sales.produto.domain;


import com.mengalisystems.erp.sales.handler.APIException;
import com.mengalisystems.erp.sales.produto.dto.ProdutoPostRequest;
import com.mengalisystems.erp.sales.produto.dto.ProdutoPutRequest;
import com.mengalisystems.erp.sales.produto.dto.ProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;


    public void deletarProduto(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        produtoRepository.delete(produto);
    }


    public ProdutoResponse cadastrarProduto(ProdutoPostRequest produtoPostRequest){
        Produto produto = produtoMapper.toProduto(produtoPostRequest);
        Produto produtoSalvo = produtoRepository.save(produto);
                return produtoMapper.toDTO(produtoSalvo);
    }

    public ProdutoResponse atualizarProduto(Long id, ProdutoPutRequest produtoPutRequest){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        produtoMapper.replaceFromDTO(produtoPutRequest, produto);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoMapper.toDTO(produtoSalvo);

    }

    public List<ProdutoResponse>buscarProdutos(){
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::toDTO)
                .toList();
    }

}
