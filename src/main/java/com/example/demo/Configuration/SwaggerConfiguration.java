package com.example.demo.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Citas Medicas")
                        .version("1.0")
                        .description("API para gestion de citas medicas")
                        .contact(new Contact()
                                .name("Desarrollador")
                                .email("citasmedicas@demo.com")));
    }
}
