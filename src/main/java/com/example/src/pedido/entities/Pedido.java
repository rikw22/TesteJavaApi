package com.example.src.pedido.entities;

import com.example.src.pedido.dto.PedidoDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "pedidos")
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataCadastro = new Date();
    private String nome;
    private Double desconto;
    private Double valorTotal;
    private Double valorUnitario;
    private Integer quantidade;
    private Long codigoCliente;
    private Integer numeroControle;

    public Pedido() { }

    public Pedido(PedidoDto dto, Double valorDesconto) {
        this.nome = dto.nome();
        this.quantidade = (dto.quantidade() != null) ? dto.quantidade() : 1;
        this.codigoCliente = dto.codigoCliente();
        this.numeroControle = dto.numeroControle();
        this.desconto = valorDesconto;
        this.valorTotal = ( this.quantidade * dto.valorUnitario() ) - valorDesconto;
        this.valorUnitario = dto.valorUnitario();
        this.dataCadastro = (dto.dataCadastro() != null) ? dto.dataCadastro() : new Date();
    }
}
