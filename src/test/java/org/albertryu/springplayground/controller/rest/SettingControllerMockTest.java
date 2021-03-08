package org.albertryu.springplayground.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.albertryu.springplayground.common.vo.HttpResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
class SettingControllerMockTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @BeforeEach
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void getPriorityMap() throws Exception {
        String resBody = mockMvc.perform(get("/setting/priority"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andReturn().getResponse().getContentAsString();
        HttpResult<String[]> httpResult = objectMapper.readValue(resBody, HttpResult.class);

        System.out.println(resBody);
        System.out.println(httpResult);

    }

    @Test
    void updatePriorityMap() throws Exception {
        String resBody = mockMvc.perform(post("/setting/priority").contentType(MediaType.APPLICATION_JSON).content("{\"aaa\":[\"1\",\"2\"]}"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andReturn().getResponse().getContentAsString();
        HttpResult<String[]> httpResult = objectMapper.readValue(resBody, HttpResult.class);

        System.out.println(resBody);
        System.out.println(httpResult);
    }
}