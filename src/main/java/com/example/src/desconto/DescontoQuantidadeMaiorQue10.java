package com.example.src.desconto;

import org.springframework.stereotype.Component;

@Component
public class DescontoQuantidadeMaiorQue10 implements DescontoHandler {

    private DescontoHandler next;

    @Override
    public Double calculaDesconto(Integer quantidade, Double valorUnitario) {
        if(quantidade != null && quantidade > 10){
            Double valorTotal = quantidade * valorUnitario;
            return valorTotal * 0.1;
        }

        return next != null ? next.calculaDesconto(quantidade, valorUnitario) : 0.0;
    }

    @Override
    public void setNext(DescontoHandler next) {
        this.next = next;
    }
}
