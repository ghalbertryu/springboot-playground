package org.albertryu.springplayground.controller.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.albertryu.springplayground.common.util.LogUtils;
import org.albertryu.springplayground.common.vo.WebSocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SendTo("/topic/res")
public class WebSocketController {

    @Autowired
    private ObjectMapper objectMapper;

    @MessageMapping("/open")
    public WebSocketMessage said(String msg) {
        log.info(LogUtils.buildClassTag(this) + "said start, msg={}", msg);
        try {
            WebSocketMessage message = objectMapper.readValue(msg, WebSocketMessage.class);
            message.setTime(new Timestamp(System.currentTimeMillis()));
            Thread.sleep(1000);
            return message;
        } catch (JsonProcessingException | InterruptedException e) {
            log.warn(LogUtils.buildClassTag(this) + "said failed!", e);
        }

        return new WebSocketMessage("sys", "error", new Timestamp(System.currentTimeMillis()));
    }
}
