package com.janwarlen.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: GateWayDemoApplication
 * @author: wangjian
 * @Date: 2020/12/10 10:48
 * @Description:
 */
@SpringBootApplication
public class GateWayDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayDemoApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                /*.route("customer", c -> c.path("/hello")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://127.0.0.1:8081/hello"))*/
                .build();
    }
}
