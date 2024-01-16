package com.example.src.pedido.repository;

import com.example.src.pedido.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Boolean existsByNumeroControle(Integer numeroControle);

    List<Pedido> findByDataCadastro(Date dataCadastro);

}
