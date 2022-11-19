package com.mb30.chartio.infra.coingecko;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(value = "chartio.infra.coingecko")
public class CoinGeckoConfig {

    private String ping;
    
    private String assetPlatforms;
}
