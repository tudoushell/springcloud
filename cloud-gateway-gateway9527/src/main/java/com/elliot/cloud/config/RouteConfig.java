package com.elliot.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由配置
 */
@Configuration
public class RouteConfig {
  /**
   * 当访问localhost:9527/bing 则会跳转到https://cn.bing.com/bing
   * @param routeLocatorBuilder
   * @return
   */
  @Bean
  public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
    RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

    routes.route("bing_route",
            r -> r.path("/bing")
                    .uri("https://cn.bing.com")).build();
    return routes.build();
  }
}
