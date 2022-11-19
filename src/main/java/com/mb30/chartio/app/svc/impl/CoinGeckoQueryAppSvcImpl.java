package com.mb30.chartio.app.svc.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mb30.chartio.app.connector.CoinConnector;
import com.mb30.chartio.app.svc.CoinQueryAppSvc;

@Service
public class CoinGeckoQueryAppSvcImpl implements CoinQueryAppSvc {

    private final CoinConnector coinConnector;

    public CoinGeckoQueryAppSvcImpl(CoinConnector coinConnector) {
        this.coinConnector = coinConnector;
    }
    
    @Override
    public <T> T ping() {
        return coinConnector.ping();
    }
    
    @Override
    public <T> List<T> assetPlatforms() {
        return coinConnector.assetPlatforms();
    }
}
