package com.cbastos.credit_application.configurations

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Swagger3Config {
    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("public-credit-application-api")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }
}
