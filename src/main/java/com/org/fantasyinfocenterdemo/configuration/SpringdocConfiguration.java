package com.org.fantasyinfocenterdemo.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class SpringdocConfiguration {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Demo Info Center API")
                        .description("Demo Info Center API")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Demo Info Center API Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}
