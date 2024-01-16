package com.example.src.pedido.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record PedidoDto(

    @NotBlank
    String nome,
    @NotNull
    Double valorUnitario,
    @NotNull
    Long codigoCliente,
    @NotNull
    Integer numeroControle,
    Integer quantidade,
    Date dataCadastro
){

}
