package org.albertryu.springplayground.config;

import java.io.IOException;
import java.util.Map;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
        WebSocketHandler wsHandler, Map<String, Object> attributes) throws IOException {
        System.out.println("RemoteAddress:{}, 請求建立連線" + request.getRemoteAddress());
        System.out.println("Header:{}" + request.getHeaders());
        System.out.println("Body:{}" + request.getBody());
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
        WebSocketHandler webSocketHandler, Exception e) {
    }
}
