package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UserApiService;
import io.swagger.api.factories.UserApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.Iuser;
import io.swagger.model.LocationPoint;
import io.swagger.model.RegistrationForm;

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

@Path("/user")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public class UserApi  {
   private final UserApiService delegate;

   public UserApi(@Context ServletConfig servletContext) {
      UserApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("UserApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (UserApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = UserApiServiceFactory.getUserApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/info")
    
    @Produces({ "application/json" })
    @Operation(summary = "get user info", description = "Send user id to get the user information ", tags={ "user_C", "user_S" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "sending user info", content = @Content(schema = @Schema(implementation = Iuser.class))),
        
        @ApiResponse(responseCode = "400", description = "cant get user info") })
    public Response getUserInfo(@Parameter(description = "",required=true) @QueryParam("userID") String userID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUserInfo(userID,securityContext);
    }
    @POST
    @Path("/register")
    @Consumes({ "application/json" })
    
    @Operation(summary = "Register new user", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "registration complete"),
        
        @ApiResponse(responseCode = "400", description = "invalid input or unable to register") })
    public Response newUser(@Parameter(description = "user registers to our database" ) RegistrationForm body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.newUser(body,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    
    @Operation(summary = "sends the location of user to the caretaker", description = "", tags={ "user_S" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "location shared"),
        
        @ApiResponse(responseCode = "400", description = "cant send the user location to caretaker") })
    public Response shareLocation(@Parameter(description = "location of the user" ) LocationPoint body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.shareLocation(body,securityContext);
    }
}
