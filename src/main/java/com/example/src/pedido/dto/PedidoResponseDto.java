package com.example.src.pedido.dto;

import com.example.src.pedido.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record PedidoResponseDto(
        Long id,
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date dataCadastro,
        String nome,
        Double desconto,
        Double valorTotal,
        Integer quantidade,
        Long codigoCliente,
        Integer numeroControle
        ) {

    public PedidoResponseDto(Pedido pedido){
        this(
                pedido.getId(),
                pedido.getDataCadastro(),
                pedido.getNome(),
                pedido.getDesconto(),
                pedido.getValorTotal(),
                pedido.getQuantidade(),
                pedido.getCodigoCliente(),
                pedido.getNumeroControle()
        );
    }
}
