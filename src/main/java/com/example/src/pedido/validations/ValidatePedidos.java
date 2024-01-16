package com.example.src.pedido.validations;

import com.example.src.pedido.dto.PedidoDto;

import java.util.List;

public interface ValidatePedidos {
    void validate(List<PedidoDto> receberListaPedidosDto);
}
