package com.cs.cp.tcb.config;


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
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    Contact contact = new Contact(
            "Pramod Narnaware",
            "http://www.singtel.com",
            "developer@singtel.com"
    );

    List<VendorExtension> vendorExtensions = new ArrayList<>();

	ApiInfo apiInfo = new ApiInfo(
			"Credit Platform app RESTful Web Service documentation",
			"This pages documents Credit Platform app RESTful Web Service endpoints",
			"1.0",
			"http://www.singtel.com",
			contact,
			"Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0",
			vendorExtensions);

    @Bean
    public Docket apiDocket() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
              //  .protocols(new HashSet<>(Arrays.asList("HTTP","HTTPs")))
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cs.cp.tcb")).paths(PathSelectors.any())
                .build();

        return docket;

    }

}

//http://localhost:8080/v2/api-docs
//http://localhost:8080/swagger-ui.html
