package com.mengalisystems.erp.sales.cliente.domain;

import com.mengalisystems.erp.sales.cliente.dto.ClientePostRequest;
import com.mengalisystems.erp.sales.cliente.dto.ClientePutRequest;
import com.mengalisystems.erp.sales.cliente.dto.ClienteResponse;
import com.mengalisystems.erp.sales.handler.APIException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;



    public void excluirCliente(Long id){
       Cliente cliente = clienteRepository.findById(id)
               .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
       clienteRepository.delete(cliente);
    }

    public ClienteResponse cadastrarCliente(ClientePostRequest clienteRequest){
        Cliente cliente = clienteMapper.toCliente(clienteRequest);
        Cliente clienteSalvo = clienteRepository.save(cliente);
                return clienteMapper.toDTO(clienteSalvo);
    }

    public ClienteResponse atualizarCliente(Long id, ClientePutRequest clienteRequest){
        Cliente cliente = clienteRepository.findById(id)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        clienteMapper.replaceFromDTO(clienteRequest, cliente);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteMapper.toDTO(clienteSalvo);
    }

   public List<ClienteResponse>buscarClientes(){
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .toList();
    }

}
