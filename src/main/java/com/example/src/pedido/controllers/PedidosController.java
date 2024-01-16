package com.example.src.pedido.controllers;

import com.example.src.pedido.dto.PedidoDto;
import com.example.src.pedido.dto.PedidoResponseDto;
import com.example.src.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos")
public class PedidosController {

    private final PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(summary = "Cadastra novos pedidos")
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity recebePedido(@RequestBody @Valid List<PedidoDto> pedidosDto) {
        pedidoService.receberPedido(pedidosDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Retorna todos os pedidos")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PedidoResponseDto>> getPedidos(
            @RequestParam(required = false) Long numeroPedido,
            @RequestParam(required = false) String dataCadastro
    ) {
        List<PedidoResponseDto> list = pedidoService.getPedidos(numeroPedido, dataCadastro);
        return ResponseEntity.ok(list);
    }

}
