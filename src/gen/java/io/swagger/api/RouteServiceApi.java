package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.RouteServiceApiService;
import io.swagger.api.factories.RouteServiceApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Date;
import io.swagger.model.DeparturePoint;
import io.swagger.model.Directions;
import io.swagger.model.LocationPoint;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/RouteService")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public class RouteServiceApi  {
   private final RouteServiceApiService delegate;

   public RouteServiceApi(@Context ServletConfig servletContext) {
      RouteServiceApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("RouteServiceApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (RouteServiceApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = RouteServiceApiServiceFactory.getRouteServiceApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    
    @Operation(summary = "Sends notification about departure", description = "", tags={ "user_S" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "notification sent"),
        
        @ApiResponse(responseCode = "400", description = "something went wrong with sending the notification") })
    public Response notify(@Parameter(description = "user sends informationa bout departure to the caretaker." ) DeparturePoint body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.notify(body,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "requests directions", description = "By sending the current location and the destination, requests path.  ", tags={ "user_S" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "succesfully received route", content = @Content(schema = @Schema(implementation = Directions.class))),
        
        @ApiResponse(responseCode = "400", description = "cant get directions") })
    public Response requestRoute(@Parameter(description = "Location of the initial point",required=true) @QueryParam("UserLocation") LocationPoint userLocation
,@Parameter(description = "destination point ",required=true) @QueryParam("DestinationLocation") LocationPoint destinationLocation
,@Parameter(description = "") @QueryParam("departureTime") Date departureTime
,@Parameter(description = "") @QueryParam("arrivalTime") Date arrivalTime
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.requestRoute(userLocation,destinationLocation,departureTime,arrivalTime,securityContext);
    }
}
