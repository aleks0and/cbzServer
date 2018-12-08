package io.swagger.api.factories;

import io.swagger.api.PlaceApiService;
import io.swagger.api.impl.PlaceApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public class PlaceApiServiceFactory {
    private final static PlaceApiService service = new PlaceApiServiceImpl();

    public static PlaceApiService getPlaceApi() {
        return service;
    }
}
