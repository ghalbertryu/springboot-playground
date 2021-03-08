package org.albertryu.springplayground.controller.rest;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SettingControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getPriorityMap() {
        ResponseEntity<String> getEntity = testRestTemplate.getForEntity("/setting/priority", String.class);
        Assertions.assertEquals(200, getEntity.getStatusCodeValue());

        System.out.println(getEntity);
        System.out.println(getEntity.getBody());
    }

    @Test
    void updatePriorityMap() {
        Map<String, String[]> reqBody = new HashMap();
        reqBody.put("aaa", new String[] {"1", "2"});

        ResponseEntity<String> postEntity = testRestTemplate.postForEntity("/setting/priority", reqBody, String.class);
        Assertions.assertEquals(200, postEntity.getStatusCodeValue());

        System.out.println(postEntity);
        System.out.println(postEntity.getBody());
    }
}