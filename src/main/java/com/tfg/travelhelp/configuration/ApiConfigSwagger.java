package com.tfg.travelhelp.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfigSwagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("TravelHelp API")
                        .description("API REST para la gestion de información relevante a la hora de viajar a un país")
                        .contact(new Contact()
                                .name("Alberto Miguel")
                                .email("ejemplo@gmail.com")
                                .url("https://github.com/AMiguelNavarro?tab=repositories"))
                        .version("1.0"));
    }

}
