package com.example.src.pedido.service;

import com.example.src.desconto.DescontoService;
import com.example.src.pedido.dto.PedidoDto;
import com.example.src.pedido.dto.PedidoResponseDto;
import com.example.src.pedido.entities.Pedido;
import com.example.src.pedido.repository.PedidoRepository;
import com.example.src.pedido.validations.ValidatePedidos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    List<ValidatePedidos> validationsListaPedidos;

    @Autowired
    DescontoService descontoService;

    @Autowired
    PedidoRepository pedidoRepository;

    @Transactional
    public List<Pedido> receberPedido(@Valid List<PedidoDto> pedidosDto) {
        validationsListaPedidos.forEach(v -> v.validate(pedidosDto));

        List<Pedido> pedidosSalvos = pedidoRepository.saveAll(pedidosDto.stream()
                .map(pedidoDto -> {
                    Double valorDesconto = descontoService.calculaDesconto(pedidoDto.quantidade(), pedidoDto.valorUnitario());
                    return new Pedido(pedidoDto, valorDesconto);
                })
                .toList());

        return pedidosSalvos;
    }


    public List<PedidoResponseDto> getPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .map(PedidoResponseDto::new)
                .toList();
    }

    public List<PedidoResponseDto> getPedidos(Long numeroPedido, String dataCadastro) {
        if(numeroPedido != null && numeroPedido > 0){
            return pedidoRepository.findById(numeroPedido)
                    .stream()
                    .map(PedidoResponseDto::new)
                    .toList();
        }

        if(dataCadastro != null && !dataCadastro.isBlank()){
            Date dataCadastroDate = Date.valueOf(dataCadastro);

            return pedidoRepository.findByDataCadastro(dataCadastroDate)
                    .stream()
                    .map(PedidoResponseDto::new)
                    .toList();
        }


        return pedidoRepository.findAll()
                .stream()
                .map(PedidoResponseDto::new)
                .toList();
    }

}
