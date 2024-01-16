package com.example.src.desconto;

import org.springframework.stereotype.Component;

@Component
public class DescontoQuantidadeMaior5Menor10 implements DescontoHandler{

    private DescontoHandler next;

    @Override
    public Double calculaDesconto(Integer quantidade, Double valorUnitario) {

        if(quantidade != null && quantidade > 5 && quantidade <= 10){
            Double valorTotal = quantidade * valorUnitario;
            return valorTotal * 0.05;
        }

        return next != null ? next.calculaDesconto(quantidade, valorUnitario) : 0.0;
    }

    @Override
    public void setNext(DescontoHandler next) {
        this.next = next;
    }
}
