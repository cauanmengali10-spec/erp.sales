package com.mengalisystems.erp.sales.cliente.domain;

import com.mengalisystems.erp.sales.cliente.dto.ClientePostRequest;
import com.mengalisystems.erp.sales.cliente.dto.ClientePutRequest;
import com.mengalisystems.erp.sales.cliente.dto.ClienteResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponse postCliente(@RequestBody @Valid ClientePostRequest clienteRequest){
        return clienteService.cadastrarCliente(clienteRequest);
    }
    @Transactional
    @PutMapping
    public ClienteResponse putCliente(@RequestBody @Valid Long id, ClientePutRequest clienteRequest){
        return clienteService.atualizarCliente(id, clienteRequest);
    }
    @GetMapping
    public List<ClienteResponse>getClientes(){
        return clienteService.buscarClientes();


    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCliente(@PathVariable Long id){
        clienteService.excluirCliente(id);
    }
}
