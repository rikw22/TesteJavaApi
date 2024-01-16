package com.example.src.pedido.validations;

import com.example.src.pedido.dto.PedidoDto;
import com.example.src.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoNaoAceitaNumeroControleJaExistente implements ValidatePedidos {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void validate(List<PedidoDto> receberListaPedidosDto) {
        receberListaPedidosDto.forEach(pedido -> {

            if (pedidoRepository.existsByNumeroControle(pedido.numeroControle())) {
                throw new ValidacaoPedidoException("Já existe um pedido com o número de controle " + pedido.numeroControle() + " cadastrado");
            }
        });
    }
}
