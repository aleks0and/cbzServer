package io.swagger.api;

import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse400;
import io.swagger.model.Place;
import io.swagger.model.Route;

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
public class ServiceApiControllerIntegrationTest {

    @Autowired
    private ServiceApi api;

    @Test
    public void serviceAccessiblePlacesPostTest() throws Exception {
        Object body = null;
        ResponseEntity<List<Place>> responseEntity = api.serviceAccessiblePlacesPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void serviceAddCommentPostTest() throws Exception {
        Object body = null;
        ResponseEntity<InlineResponse200> responseEntity = api.serviceAddCommentPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void serviceRoutesPostTest() throws Exception {
        Object body = null;
        ResponseEntity<List<Route>> responseEntity = api.serviceRoutesPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
