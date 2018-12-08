package io.swagger.api;

import io.swagger.model.InlineResponse400;
import io.swagger.model.Place;
import io.swagger.model.User;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewApiControllerIntegrationTest {

    @Autowired
    private ViewApi api;

    @Test
    public void viewDisabilitiesGetTest() throws Exception {
        ResponseEntity<List<Place>> responseEntity = api.viewDisabilitiesGet();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void viewPlacesGetTest() throws Exception {
        ResponseEntity<List<Place>> responseEntity = api.viewPlacesGet();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void viewUsersGetTest() throws Exception {
        ResponseEntity<List<User>> responseEntity = api.viewUsersGet();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
