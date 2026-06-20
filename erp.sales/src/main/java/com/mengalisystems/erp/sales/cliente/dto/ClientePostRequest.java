package com.mengalisystems.erp.sales.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientePostRequest {

    @NotBlank
    private String nome;
    private String cpf;
    @Email
    private String email;
}
