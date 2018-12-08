package io.swagger.api.factories;

import io.swagger.api.RouteServiceApiService;
import io.swagger.api.impl.RouteServiceApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public class RouteServiceApiServiceFactory {
    private final static RouteServiceApiService service = new RouteServiceApiServiceImpl();

    public static RouteServiceApiService getRouteServiceApi() {
        return service;
    }
}
