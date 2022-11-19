package com.mb30.chartio.infra.config;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Data;
import reactor.netty.http.client.HttpClient;

@Data
@Configuration
@ConfigurationProperties(value = "chartio.infra.webclient")
public class WebClientConfig {
    /**
     * Max connection total.
     */
    private int maxConnectionTotal = 200;

    /**
     * Max connection per route (e.g., foo.com & bar.com are 2 separated routes, foo.com/path-one & foo.com/path-two
     * all belong to a same route).
     */
    private int maxConnectionPerRoute = 200;

    /**
     * Connect timeout in ms.
     */
    private int connectTimeoutMs = 5_000;

    /**
     * Read timeout (between received packets) in ms.
     */
    private int readTimeoutMs = 20_000;
    
    private int writeTimeoutMs = 20_000;
    
    
    /**
     * Connection requested from pool timeout in ms.
     */
    private int connectionRequestTimeoutMs = 5_000;

    private String coinGeckoBaseUrl;

    private WebClient createWebClient(String baseUrl) {
        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient());
    
        return WebClient.builder()
                   .baseUrl(baseUrl)
                   .clientConnector(connector)
                   .defaultCookie("cookieKey", "cookieValue")
                   .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                   .defaultUriVariables(Collections.singletonMap("url", baseUrl))
                   .build();
    }

    private HttpClient httpClient() {
        return HttpClient.create()
               .tcpConfiguration(
                   client -> client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeoutMs)
                                 .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(readTimeoutMs, TimeUnit.MILLISECONDS))
                                                            .addHandlerLast(new WriteTimeoutHandler(writeTimeoutMs, TimeUnit.MILLISECONDS))));
    }

    @Bean
    public WebClient coinGeckoWebClient() {
        return createWebClient(coinGeckoBaseUrl);
    }

}
