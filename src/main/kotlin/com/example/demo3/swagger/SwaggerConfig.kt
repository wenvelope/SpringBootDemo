package com.example.demo3.swagger

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@EnableKnife4j
@Configuration
@EnableOpenApi
class SwaggerConfig {
    @Bean
    fun testApi():Docket{
        return Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .select()
            .build()
    }

    private fun apiInfo():ApiInfo{
        return ApiInfoBuilder()
            .title("Test接口文档")
            .description("author:老吴")
            .contact(Contact("老吴","https://wenvelope.github.io/","1425636954@qq.com"))
            .version("1.0")
            .build()
    }


}