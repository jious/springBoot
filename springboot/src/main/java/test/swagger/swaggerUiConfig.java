package test.swagger;/*
import	java.util.regex.Pattern.Category;
    @author : parry
    @Create : 2019-09-28 14:19
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class swaggerUiConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

//        @Bean
//        public Docket api() {
//
//            return new Docket(DocumentationType.SWAGGER_2)
//
//                    .select()
//
//                    .apis(RequestHandlerSelectors.basePackage("test.controller"))
//
//                    .paths(Predicates.or(PathSelectors.ant("/user/add"),
//                            PathSelectors.ant("/user/find/*"),
//                            PathSelectors.ant("/user/delete/*"),
//                            PathSelectors.ant("/user/update")))
//                    .build()
//
//                    .apiInfo(apiInfo())
//
//                    .useDefaultResponseMessages(false)
//
//                    .globalResponseMessage(RequestMethod.GET, newArrayList(
//
//                            new ResponseMessageBuilder()
//
//                                    .code(500)
//
//                                    .message("服务器发生异常")
//
//                                    .responseModel(new ModelRef("Error"))
//
//                                    .build(),
//
//                            new ResponseMessageBuilder()
//
//                                    .code(403)
//
//                                    .message("资源不可用")
//
//                                    .build()
//
//                    ));

//        }
//
//
//
//        private ApiInfo apiInfo() {
//
//            return new ApiInfo(
//
//                    "Spring Boot项目集成Api文档",
//
//                    "  作者：parry-zeng",
//
//                    "API V1.0",
//
//                    "",
//
//                    new Contact("", "", ""),
//
//                    "", "", Collections.emptyList());
//
//        }
    }


