package com.example.demo6574564.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 * @date 2019-10-10 16:25
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     *     swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //协议，http或https
                .protocols(Sets.newHashSet("http"))
                .apiInfo(apiInfo())
                .select()
                //controller扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demo6574564.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     *    构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("RestFul接口定义")
                //版本号
                .version("1.0")
                //描述
                .description("用于测试RestFul Api")
                .build();
    }
}
