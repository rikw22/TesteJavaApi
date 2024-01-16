package com.example.src.pedido.controllers;

import com.example.src.pedido.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PedidosControllerTest {

    @Autowired
    private PedidoRepository pedidosRepository;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        pedidosRepository.deleteAll();
    }

    @Test
    void recebePedidoJson() throws Exception {
        String json = """
                [
                        {
                            "dataCadastro": "2024-01-01",
                            "nome": "nome",
                            "valorUnitario": 10.0,
                            "quantidade": 10,
                            "codigoCliente": 1,
                            "numeroControle": 10
                        }
                ]
                """;
        mvc.perform(post("/api/pedidos")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void recebePedidoJsonValidacao() throws Exception {
        String json = """
                [{}]
                """;
        mvc.perform(post("/api/pedidos")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().is4xxClientError());
    }


    @Test
    void deveAceitar10Pedidos() throws Exception {
        String json = """
                [
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 10
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 2",
                        "valorUnitario": 11.0,
                        "quantidade": 11,
                        "codigoCliente": 2,
                        "numeroControle": 11
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 3",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 12
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 4",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 13
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 5",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 14
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 6",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 15
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 7",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 16
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 8",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 17
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 9",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 18
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 10",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 19
                    }
                ]
                """;
            mvc.perform(post("/api/pedidos")
                    .contentType("application/json")
                    .content(json))
                    .andExpect(status().isOk());
    }

    @Test
    void dadoQuantidadeDePedidosMaiorQue10RetornaErro() throws Exception {
        String json = """
                [
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 10
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome 2",
                        "valorUnitario": 11.0,
                        "quantidade": 11,
                        "codigoCliente": 2,
                        "numeroControle": 11
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 12
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 13
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 14
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 15
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 16
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 17
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 18
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 19
                    },
                    {
                        "dataCadastro": "2024-01-01",
                        "nome": "nome",
                        "valorUnitario": 10.0,
                        "quantidade": 10,
                        "codigoCliente": 1,
                        "numeroControle": 20
                    }
                ]
                """;


        mvc.perform(post("/api/pedidos")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void recebePedidoXml() throws Exception {
        String xml = """
                <pedidos>
                    <pedido>
                        <dataCadastro>2024-01-01</dataCadastro>
                        <nome>nome</nome>
                        <valorUnitario>10.0</valorUnitario>
                        <quantidade>10</quantidade>
                        <codigoCliente>1</codigoCliente>
                        <numeroControle>10</numeroControle>
                    </pedido>
                    <pedido>
                        <dataCadastro>2024-01-01</dataCadastro>
                        <nome>nome 2</nome>
                        <valorUnitario>11.0</valorUnitario>
                        <quantidade>11</quantidade>
                        <codigoCliente>2</codigoCliente>
                        <numeroControle>11</numeroControle>
                    </pedido>
                </pedidos>
                """;
        mvc.perform(post("/api/pedidos")
                        .contentType("application/xml")
                        .content(xml))
                .andExpect(status().isOk());
    }

    @Test
    void recebePedidoXmlValidacao() throws Exception {
        String xml = """
                <pedidos>
                    <pedido>
                        <dataCadastro></dataCadastro>
                        <nome></nome>
                        <valorUnitario></valorUnitario>
                        <quantidade></quantidade>
                        <codigoCliente></codigoCliente>
                        <numeroControle></numeroControle>
                    </pedido>
                </pedidos>
                """;
        mvc.perform(post("/api/pedidos")
                        .contentType("application/xml")
                        .content(xml))
                .andExpect(status().is4xxClientError());
    }
}