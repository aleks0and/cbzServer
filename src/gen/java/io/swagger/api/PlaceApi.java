package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PlaceApiService;
import io.swagger.api.factories.PlaceApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.Comment;
import io.swagger.model.Institution;
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

@Path("/Place")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public class PlaceApi  {
   private final PlaceApiService delegate;

   public PlaceApi(@Context ServletConfig servletContext) {
      PlaceApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PlaceApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PlaceApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PlaceApiServiceFactory.getPlaceApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/find")
    
    @Produces({ "application/json" })
    @Operation(summary = "find nearby places", description = "", tags={ "user_S" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "received nearby places", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Institution.class)))),
        
        @ApiResponse(responseCode = "400", description = "cant get nearby places") })
    public Response findPlacesNearby(@Parameter(description = "Location of the initial point",required=true) @QueryParam("UserLocation") LocationPoint userLocation
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findPlacesNearby(userLocation,securityContext);
    }
    @POST
    @Path("/mark")
    @Consumes({ "application/json" })
    
    @Operation(summary = "User comments over the places disability availability", description = "", tags={ "user_S" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "succesfull marking"),
        
        @ApiResponse(responseCode = "403", description = "invalid input, object invalid") })
    public Response markPlace(@Parameter(description = "" ) Comment body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.markPlace(body,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "get place information", description = "By sending the palce location or id, requests infroamtion about place.  ", tags={ "user_S" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(schema = @Schema(implementation = Institution.class))),
        
        @ApiResponse(responseCode = "400", description = "cant get place info") })
    public Response requestRoute(@Parameter(description = "Id of place to look for") @QueryParam("PlaceId") String placeId
,@Parameter(description = "location of point to look for") @QueryParam("placeLocation") LocationPoint placeLocation
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.requestRoute(placeId,placeLocation,securityContext);
    }
}
