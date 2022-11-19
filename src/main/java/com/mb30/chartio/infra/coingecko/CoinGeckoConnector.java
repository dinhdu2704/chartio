package com.mb30.chartio.infra.coingecko;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.reactive.function.client.WebClient;

import com.mb30.chartio.app.connector.CoinConnector;
import com.mb30.chartio.domain.exception.DomainException;
import com.mb30.chartio.domain.model.coingecko.AssetPlatform;
import com.mb30.chartio.domain.model.coingecko.Ping;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class CoinGeckoConnector implements CoinConnector {

    private final WebClient coinGeckoWebClient;

    private final CoinGeckoConfig coinGeckoConfig;

    public CoinGeckoConnector(@Qualifier(value = "coinGeckoWebClient") WebClient coinGeckoWebClient,
                              CoinGeckoConfig coinGeckoConfig) {
        this.coinGeckoWebClient = coinGeckoWebClient;
        this.coinGeckoConfig = coinGeckoConfig;
    }

    @Override
    public Ping ping() {
        return handleSvcCall(HttpMethod.GET, coinGeckoConfig.getPing(), null, Ping.class);
    }
    
    @Override
    public List<AssetPlatform> assetPlatforms() {
        return handleSvcCall(HttpMethod.GET, coinGeckoConfig.getAssetPlatforms(), null, List.class);
    }

    private <T> T handleSvcCall(HttpMethod method, String url, String payload, Class<T> clazz) {
        try {
            ResponseEntity<T> response = coinGeckoWebClient
                                             .method(method)
                                             .uri(url)
                                             .bodyValue(!StringUtils.isEmpty(payload) ? payload : "")
                                             .retrieve()
                                             .toEntity(clazz)
                                             .block();

            log.info("method: handleSvcCall - response: {}", response);

            return response.getBody();
        } catch (RestClientResponseException e) {
            throw new DomainException(e.getMessage(), e);
        } catch (ResourceAccessException e) {
            throw new DomainException(e.getMessage());
        }
    }
}
