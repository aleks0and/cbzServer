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
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

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


    private boolean checkIfNotMovedFor10Requestes(ArrayList<Object> locationList){
        List<BigDecimal> listLng = new ArrayList<>();
        List<BigDecimal> listLat = new ArrayList<>();
        for (Object o : locationList)
        {
            String lng = ((Map<String,String>)o).get("lat");
            String lat = ((Map<String,String>)o).get("lng");
            listLng.add(new BigDecimal(lng.replaceAll(",", "")));
            listLat.add(new BigDecimal(lat.replaceAll(",", "")));
        }
        //for (int i = 1; i < listLat.size(); i++)
        for (int i = 1; i < 3; i++)
        {
            double dist = Math.sqrt(Math.pow(listLat.get(i).subtract(listLat.get(i-1)).doubleValue(),2)+Math.pow(listLng.get(i).subtract(listLng.get(i-1)).doubleValue(),2));
            if (dist > 50)
                return true;
        }

        return false;
    }
    private Map<String,Object> updateLocationRating(Map<String,Object> User, Map<String,Object> location){
        ArrayList<Object> userDisabilities = (ArrayList<Object>)User.get("disabilityType");
        Map<String,Object> locationDiabilityRating = new LinkedHashMap<>();
        if((Map<String, Object>)location.get("placeScore")!= null) {
            locationDiabilityRating = (Map<String, Object>) location.get("placeScore");
        }
        for (Object o: userDisabilities){
            if (locationDiabilityRating.get(((Map<String,Object>)o).get("name")) != null){
                int currentRating = Integer.parseInt((String)locationDiabilityRating.get((String)o));
                currentRating ++;
                locationDiabilityRating.put((String)o,Integer.toString(currentRating));
            }
            else{
                locationDiabilityRating.put((String)((Map<String,Object>)o).get("name"),Integer.toString(1));
            }
        }
        location.put("placeScore",locationDiabilityRating);
        return location;
    }


    private ArrayList<Double> getDisabilityList(Map<String, Object> entity, boolean isLocation){
        ArrayList<Double> disabilities = new ArrayList<>();
        if (entity.size()!=0) {
            if (isLocation){
                ArrayList<Object> DisabilityFlags = (ArrayList<Object>)entity.get("placeScore");
            }
            else
            {
                ArrayList<Object> DisabilityFlags = (ArrayList<Object>)entity.get("disabilityType");
            }
        }
        return disabilities;
    }
    private Map<String,Object> findNearestPlace(Map<String,Object> Currentloc)
    {
        Map<String,Object> newLocation = new LinkedHashMap<>();
        newLocation.put("description","sample Disc");
        newLocation.put("email","email@example.pl");
        newLocation.put("id","customId");
        newLocation.put("location",Currentloc);
        newLocation.put("name","email@example.pl");
        newLocation.put("phone","customId");
        return newLocation;
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
                if (checkIfNotMovedFor10Requestes(locationsUpdate)){
                    Map<String,Object> loc = new LinkedHashMap<>();
                    String firebase_baseLocUrl = "https://hackhaton-cbz.firebaseio.com/places/";
                    firebase_baseLocUrl = firebase_baseLocUrl + Currentloc.get("lat")+ Currentloc.get("lng");
                    Firebase firebaseLoc = new Firebase(firebase_baseLocUrl);
                    Map<String,Object> dataLocBaseBody = (Map<String,Object>)firebaseLoc.get().getBody();
                    if(dataLocBaseBody.size()!=0)
                    {
                        loc = updateLocationRating(User,dataLocBaseBody);
                    }
                    else
                    {
                        Map<String,Object> newLocation = findNearestPlace(Currentloc);
                        loc = updateLocationRating(User,newLocation);
                    }
                    firebaseLoc.put(loc);

                }
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
