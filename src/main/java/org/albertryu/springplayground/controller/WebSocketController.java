package org.albertryu.springplayground.controller;

import org.albertryu.springplayground.model.ServerResponseModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SendTo("/topic/res")
public class WebSocketController {
    @MessageMapping("/open")
    public ServerResponseModel said(String msg) throws InterruptedException{
        System.out.println(msg);
        Thread.sleep(3000);
        return new ServerResponseModel("歡迎來到," + msg);
    }
}
