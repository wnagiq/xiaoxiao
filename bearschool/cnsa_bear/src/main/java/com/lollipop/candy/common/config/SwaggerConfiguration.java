package com.lollipop.candy.common.config;

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

/**
 * SwaggerConfiguration Swagger classApi文档配置文件
 * @author xiaoxiao
 *
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        // 选择swagger2版本
        return new Docket(DocumentationType.SWAGGER_2)
                //定义api文档汇总信息
                .apiInfo(apiInfo())
                .select()
                // 指定生成api文档的包
                .apis(RequestHandlerSelectors.basePackage("com.lollipop"))
                // 指定所有路径
                .paths(PathSelectors.any())
                .build()
                ;
    }

    /**
     * 构建文档api信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("文档标题")
                //联系人信息
                .contact(new Contact("name", "url", "mail"))
                //描述
                .description("描述")
                //文档版本号
                .version("1.0")
                //网站地址
                .termsOfServiceUrl("http://localhost:9527")
                .build();
    }
}