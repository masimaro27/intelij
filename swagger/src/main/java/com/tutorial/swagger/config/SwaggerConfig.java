package com.tutorial.swagger.config;

import com.tutorial.swagger.component.EmailAnnotationPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import({
        BeanValidatorPluginsConfiguration.class,
        EmailAnnotationPlugin.class,
})
public class SwaggerConfig {

    private String version;
    private String title;

    @Bean
    public Docket apiV1() {
        version = "V12524124";
        title = "tutorial Swagger API_" + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();


    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("MERCHANT API", " ", " ", "Terms of service", new Contact("name ", "url", "email"), "License of API", "licenseUrl", Collections.emptyList());
        return apiInfo;
    }

    @Bean
    public EmailAnnotationPlugin emailPlugin() {
        return new EmailAnnotationPlugin();
    }

}
