package com.mb30.chartio.app.connector;

import java.util.List;

public interface CoinConnector {
    <T> T ping();
    
    <T> List<T> assetPlatforms();
}
