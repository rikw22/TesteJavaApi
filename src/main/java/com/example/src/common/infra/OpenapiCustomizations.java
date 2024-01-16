package com.example.src.common.infra;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenapiCustomizations {
    @Bean
    public OpenAPI customizationsOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("API de Pedidos"));
    }
}
