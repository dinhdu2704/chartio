package com.mb30.chartio.infra.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mb30.chartio.app.svc.CoinQueryAppSvc;
import com.mb30.chartio.domain.model.coingecko.Category;


@RestController
public class CoinController {

    private final CoinQueryAppSvc coinGeckoQueryAppSvc;

    public CoinController(CoinQueryAppSvc coinGeckoQueryAppSvc) {
        this.coinGeckoQueryAppSvc = coinGeckoQueryAppSvc;
    }

    @GetMapping("/ping")
    public <T> T ping() {
        return coinGeckoQueryAppSvc.ping();
    }
    
    @GetMapping("/asset_platforms")
    public <T> List<T> assetPlatforms() {
        return coinGeckoQueryAppSvc.assetPlatforms();
    }
    
    
    
}
