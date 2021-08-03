package com.northbear.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/3 11:32
 */
//@Configuration 通过编写类的方式实现路由功能
public class GateWayConfig {

    /**
     *
     * @param routeLocatorBuilder
     * @return 编码方式实现路由转发网关
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_northbear",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
