package com.mengalisystems.erp.sales.produto.domain;

import com.mengalisystems.erp.sales.produto.dto.ProdutoPostRequest;
import com.mengalisystems.erp.sales.produto.dto.ProdutoPutRequest;
import com.mengalisystems.erp.sales.produto.dto.ProdutoResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;


    @Transactional
    @DeleteMapping("/{id}")
    public void DeleteProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse postProduto(@RequestBody @Valid ProdutoPostRequest produtoPostRequest){
        return produtoService.cadastrarProduto(produtoPostRequest);
    }

    @Transactional
    @PutMapping
    public ProdutoResponse putProduto(@RequestBody @Valid Long id, ProdutoPutRequest produtoPutRequest){
        return produtoService.atualizarProduto(id, produtoPutRequest);
    }

    @GetMapping
    public List<ProdutoResponse>getProdutos(){
        return produtoService.buscarProdutos();
    }

}
