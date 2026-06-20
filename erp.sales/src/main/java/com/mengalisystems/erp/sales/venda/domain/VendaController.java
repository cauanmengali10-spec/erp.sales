package com.mengalisystems.erp.sales.venda.domain;


import com.mengalisystems.erp.sales.venda.dto.VendaRequest;
import com.mengalisystems.erp.sales.venda.dto.VendaResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaResponse faturarNota(@RequestBody @Valid VendaRequest vendaRequest){
        return vendaService.salvar(vendaRequest);
    }

    @GetMapping
    public List<VendaResponse>buscarVendas(){
        return vendaService.buscarVendas();
    }

}
