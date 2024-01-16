package com.example.src.desconto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {

    final List<DescontoHandler> descontoHandlers;

    public DescontoService(List<DescontoHandler> descontoHandlers) {
        this.descontoHandlers = descontoHandlers;
    }

    public Double calculaDesconto(Integer quantidade, Double valorUnitario) {
        DescontoHandler descontoHandler = getDescontoHandler();
        return descontoHandler.calculaDesconto(quantidade, valorUnitario);
    }

    private DescontoHandler getDescontoHandler(){
        DescontoHandler descontoHandler = descontoHandlers.getFirst();
        for (int i = 0; i < descontoHandlers.size(); i++) {
            if(i == descontoHandlers.size() - 1){
                break;
            }
            descontoHandler.setNext(descontoHandlers.get(i + 1));
        }
        return descontoHandler;
    }
}
