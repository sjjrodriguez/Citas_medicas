package com.example.demo.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @OpenAPIDefinition(
        info = @Info(
                title = "Citas Médicas API",
                version = "1.0.0",
                description = "Sistema de gestión de citas médicas",
                contact = @Contact(name = "Tu Nombre", email = "tu@email.com"),
                license = @License(name = "MIT", url = "https://opensource.org/licenses/MIT")
        )
    )

    @Configuration
    public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("citas-medicas")
                .pathsToMatch("/api/**")
                .build();
    }
}
