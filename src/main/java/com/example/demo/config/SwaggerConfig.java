package com.example.demo.config;
import java.util.Collections;
import	java.util.function.Predicate;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Documentation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//    }

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)

                .select()

                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))

                .paths(Predicates.or(PathSelectors.ant("/user/add"),
                        PathSelectors.ant("/user/find/*"),
                        PathSelectors.ant("/user/delete/*"),
                        PathSelectors.ant("/user/update")))
                .build()

                .apiInfo(apiInfo())

                .useDefaultResponseMessages(false)

                .globalResponseMessage(RequestMethod.GET, newArrayList(

                        new ResponseMessageBuilder()

                                .code(500)

                                .message("服务器发生异常")

                                .responseModel(new ModelRef("Error"))

                                .build(),

                        new ResponseMessageBuilder()

                                .code(403)

                                .message("资源不可用")

                                .build()

                ));

    }



    private ApiInfo apiInfo() {

        return new ApiInfo(

                "Spring Boot项目集成Api文档",

                "  作者：parry-zeng",

                "API V1.0",

                "",

                new Contact("", "", ""),

                "", "", Collections.emptyList());

    }
    }
