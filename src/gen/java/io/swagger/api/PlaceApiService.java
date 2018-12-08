package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Comment;
import io.swagger.model.Institution;
import io.swagger.model.LocationPoint;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public abstract class PlaceApiService {
    public abstract Response findPlacesNearby( @NotNull LocationPoint userLocation,SecurityContext securityContext) throws NotFoundException;
    public abstract Response markPlace(Comment body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response requestRoute( String placeId, LocationPoint placeLocation,SecurityContext securityContext) throws NotFoundException;
}
