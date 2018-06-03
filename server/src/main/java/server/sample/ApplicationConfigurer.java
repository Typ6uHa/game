package server.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@ComponentScan(basePackages = "server")
@EnableJpaRepositories(basePackages = "server.repository")
@EntityScan(basePackages = "server.model")
public class ApplicationConfigurer implements WebSocketConfigurer {

    @Autowired
    SimpleServerWebSocketHandler simpleServerWebSocketHandler;

    @Override public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(simpleServerWebSocketHandler, "/echo");
    }
}
