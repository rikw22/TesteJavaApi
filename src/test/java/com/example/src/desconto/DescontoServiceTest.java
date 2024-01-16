package com.example.src.desconto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DescontoServiceTest {

    @Autowired
    DescontoService descontoService;

    @Test
    @DisplayName("Dado que a quantidade é menor ou igual a cinco, deve retornar 0 desconto")
    void dadoQuantidadeMenorOuIgualCincoNaoRetornaDesconto() {
        Double desconto1 = descontoService.calculaDesconto(1, 100.0);
        assertEquals(0.0, desconto1);

        Double desconto2 = descontoService.calculaDesconto(5, 100.0);
        assertEquals(0.0, desconto2);
    }

    @Test
    @DisplayName("Dado que a quantidade é maior que cinco, deve retornar o valor correspondente a 5% de desconto")
    void dadoQuantidadeMaiorQueCincoRetornaDescontoCincoPorCento() {
        Double desconto = descontoService.calculaDesconto(6, 100.0);
        assertEquals(30.0, desconto);

        Double desconto2 = descontoService.calculaDesconto(10, 100.0);
        assertEquals(50.0, desconto2);
    }

    @Test
    @DisplayName("Dado que a quantidade é maior que dez, deve retornar o valor correspondente a 10% de desconto")
    void dadoQuantidadeMaiorQueDezRetornaDescontoDezPorCento() {
        Double desconto = descontoService.calculaDesconto(11, 100.0);
        assertEquals(110.0, desconto);

        Double desconto2 = descontoService.calculaDesconto(500, 100.0);
        assertEquals(5000, desconto2);

    }
}