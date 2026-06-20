package com.mengalisystems.erp.sales.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ClientePutRequest {

    private Long id;
    @NotBlank
    private String nome;
    private String cpf;
    @Email
    private String email;
}
