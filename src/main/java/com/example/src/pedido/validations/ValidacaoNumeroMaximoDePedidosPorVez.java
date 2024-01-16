package com.example.src.pedido.validations;

import com.example.src.pedido.dto.PedidoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoNumeroMaximoDePedidosPorVez implements ValidatePedidos {

    @Override
    public void validate(List<PedidoDto> listaPedidos) {
        if (listaPedidos.size() > 10) {
            throw new ValidacaoPedidoException("Número máximo de pedidos por vez é 10");
        }
    }
}
