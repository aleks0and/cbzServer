package io.swagger.api;

import com.google.gson.*;
import io.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.service.Firebase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-08T19:00:38.207Z[GMT]")

@Controller
public class ViewApiController implements ViewApi {

    private static final Logger log = LoggerFactory.getLogger(ViewApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ViewApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<String>> viewDisabilitiesGet() {
        String accept = request.getHeader("Accept");
        List<String> result = new ArrayList<String>();

        String firebase_baseUrl = "https://hackhaton-cbz.firebaseio.com/disabilities";

        if( firebase_baseUrl == null || firebase_baseUrl.trim().isEmpty() ) {
            throw new IllegalArgumentException( "Program-argument 'baseUrl' not found but required" );
        }
        // create the firebase
        Firebase firebase = null;
        try {
            firebase = new Firebase( firebase_baseUrl );

            Map<String,Object> map = firebase.get().getBody();
            map.remove("name");
            for (Object o : map.values()) {
                Map<String,String> val = (LinkedHashMap<String,String >) o;
                result.add( val.get("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } catch (FirebaseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<String>>(HttpStatus.OK).ok(result);
    }

    public ResponseEntity<List<Place>> viewPlacesGet() {
        String accept = request.getHeader("Accept");
        List<Place> result = new ArrayList<>();


        String firebase_baseUrl = "https://hackhaton-cbz.firebaseio.com/places";

        if( firebase_baseUrl == null || firebase_baseUrl.trim().isEmpty() ) {
            throw new IllegalArgumentException( "Program-argument 'baseUrl' not found but required" );
        }
        // create the firebase
        Firebase firebase = null;
        try {
            firebase = new Firebase( firebase_baseUrl );

            JsonParser jsonParser = new JsonParser();

            JsonArray bodyValues = jsonParser.parse(firebase.get().getRawBody()).getAsJsonArray();
            for (JsonElement bodyValue : bodyValues) {
                if(bodyValue instanceof JsonNull)
                    continue;
                JsonObject placeJson = bodyValue.getAsJsonObject();
                Place place = new Place();
                place.setId(placeJson.get("id").getAsString());
                place.setDescription(placeJson.get("description").getAsString());
                JsonObject locationJson = placeJson.getAsJsonObject("location");
                Location loc = new Location();
                loc.setLat(locationJson.get("lat").getAsString());
                loc.setLng(locationJson.get("lng").getAsString());
                place.setLocation(loc);
                JsonObject placeScore = placeJson.getAsJsonObject("placeScore");
                List<PlaceScore> psList = new ArrayList<>();
                for (String s : viewDisabilitiesGet().getBody()) {
                    PlaceScore pscore = new PlaceScore();
                    JsonElement jsonElement = placeScore.get(s);
                    if (jsonElement != null) {
                        String val = placeScore.get(s).getAsString();
                        Disability disability = new Disability();
                        disability.setName(s);
                        pscore.setDisability(disability);
                        pscore.setScore(val);
                        psList.add(pscore);
                    }
                }

                    place.setPlaceScore(psList);
                    result.add(place);
            }



        } catch (Exception e) {
            e.printStackTrace();
        } catch (FirebaseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Place>>(HttpStatus.OK).ok(result);
    }

    public ResponseEntity<List<User>> viewUsersGet() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
