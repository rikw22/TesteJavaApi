package com.example.src.pedido.validations;

import com.example.src.cliente.repository.ClienteRepository;
import com.example.src.pedido.dto.PedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoClienteExiste implements ValidatePedidos {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void validate(List<PedidoDto> receberListaPedidosDto) {
        receberListaPedidosDto.forEach(pedido -> {

            if(!repository.existsById(pedido.codigoCliente())) {
                throw new ValidacaoPedidoException("Cliente não existe");
            }

        });
    }
}
