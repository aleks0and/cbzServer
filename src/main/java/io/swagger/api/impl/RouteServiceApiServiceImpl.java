package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import java.util.Date;
import io.swagger.model.DeparturePoint;
import io.swagger.model.Directions;
import io.swagger.model.LocationPoint;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public class RouteServiceApiServiceImpl extends RouteServiceApiService {
    @Override
    public Response notify(DeparturePoint body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response requestRoute( @NotNull LocationPoint userLocation,  @NotNull LocationPoint destinationLocation,  Date departureTime,  Date arrivalTime, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
