package com.example.src.desconto;

public interface DescontoHandler {

        Double calculaDesconto(Integer quantidade, Double valor);

        void setNext(DescontoHandler next);
}
