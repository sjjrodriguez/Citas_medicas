package com.example.demo.Configuration;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.*;
import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Citas Médicas")
                        .description("Gestión de citas, doctores, pacientes, exámenes y comprobantes")
                        .version("1.0.0")
                        .contact(new Contact().name("Dev Team").email("dev@citasmedicas.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Docker Local")
                ));
    }
}