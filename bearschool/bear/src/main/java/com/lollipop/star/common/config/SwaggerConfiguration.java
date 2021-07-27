package com.lollipop.star.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)      // 选择swagger2版本
                .apiInfo(apiInfo())         //定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.tianyin"))  // 指定生成api文档的包
                .paths(PathSelectors.any())    // 指定所有路径
                .build()
                ;
    }

    /**
     * 构建文档api信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("文档标题")     // 文档标题
                .contact(new Contact("name", "url", "mail"))   //联系人信息
                .description("描述")      //描述
                .version("1.0")     //文档版本号
                .termsOfServiceUrl("http://localhost:8080")     //网站地址
                .build();
    }
}
