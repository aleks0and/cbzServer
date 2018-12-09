package io.swagger.api;

import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse400;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
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
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-08T19:00:38.207Z[GMT]")

@Controller
public class UpdateApiController implements UpdateApi {

    private static final Logger log = LoggerFactory.getLogger(UpdateApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UpdateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public class Disability{
        String id;
        String name;

        public Disability(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    public class user{
        String id;
        String name;
        String Surname;
        String email;
        Disability[] disabilityType;
        user[] Caretaker;

        public user(String id, String name, String surname, String email, Disability[] disabilityType, user[] caretaker) {
            this.id = id;
            this.name = name;
            Surname = surname;
            this.email = email;
            this.disabilityType = disabilityType;
            Caretaker = caretaker;
        }
    }

    public ResponseEntity<InlineResponse200> updateLocationPost(@ApiParam(value = ""  )  @Valid @RequestBody Object body) {
        String accept = request.getHeader("Accept");
        String firebase_baseUrl = "https://hackhaton-cbz.firebaseio.com/user/";
        String test = body.toString();
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map<String,Object>> requestMap = (Map<String,Map<String,Object>>)body;
        Map<String,Object> Currentloc = requestMap.get("currentLocation");
        Map<String,Object> User = requestMap.get("user");
        String UserId = (String) User.get("id");
        firebase_baseUrl = firebase_baseUrl + UserId;
        try {
            Firebase firebase = new Firebase(firebase_baseUrl);
            Map<String,Object> databaseBody = (Map<String,Object>)firebase.get().getBody();
            if (databaseBody.size()!=0){
                ArrayList<Object> locationsUpdate = (ArrayList<Object>)databaseBody.get("lastLocations");
                if (locationsUpdate != null){
                    ArrayList<Object> newLocations = new ArrayList<>();
                    if(locationsUpdate.size()<10){
                        locationsUpdate.add(Currentloc);
                    }
                    else{
                        for(int i = 1; i<10; i++){
                            newLocations.add(locationsUpdate.get(i));
                        }
                        newLocations.add(Currentloc);
                        locationsUpdate = newLocations;
                    }
                }
                Map<String,Object> databseUpdate = new LinkedHashMap<>();
                for (String k : databaseBody.keySet()){
                    databseUpdate.put(k,User.get(k));
                }
                databseUpdate.put("lastLocations",locationsUpdate);
                firebase.put(databseUpdate);
            }
            else{
                Map<String,Object> databseUpdate = new LinkedHashMap<>();
                for (String k : User.keySet()){
                    databseUpdate.put(k,User.get(k));
                }
                Map<String,Object> locationsArray = new LinkedHashMap<>();
                locationsArray.put("0",Currentloc);
                databseUpdate.put("lastLocations",locationsArray);
                firebase.put(databseUpdate);
            }
        }
        catch (FirebaseException e){
            System.out.println(e);
        }
        catch (UnsupportedEncodingException e){
            System.out.println(e);
        }
        catch (JacksonUtilityException e){
            System.out.println(e);
        }

        /*try {


            user[] userFromJSON = mapper.readValue(test, user[].class);
            System.out.println("try");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }*/
        //LinkedHashMap user = (LinkedHashMap)body.get((LinkedHashMap)user);
        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse200> updateUserPost(@ApiParam(value = ""  )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

}
