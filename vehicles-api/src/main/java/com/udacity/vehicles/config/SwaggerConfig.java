package com.udacity.vehicles.config;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableSwagger2
@ApiResponses( value ={
        @ApiResponse(code = 400,message = "This is a bad request, please follow API documentation"),
        @ApiResponse(code = 401,message = "Due to security reasons,your access request cannot be authorized"),
        @ApiResponse(code = 500,message = "The server is down.Please contact system Administrator")
})
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().useDefaultResponseMessages(false).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
            ApiInfo apiInfo = new ApiInfo(
                "Vehicles REST API", "Vehicles API  Car System",
                "1.0",
                "Terms of service",
                new Contact("Mahmoud Allam", "https://www.mallam.de", "mahmoudallam@gmx.de"),
                        "Apache License Version 2.0",
                        "https://www.apache.org/licenses/LICENSE-2.0", Collections.EMPTY_LIST);
            return apiInfo;
        }


}
