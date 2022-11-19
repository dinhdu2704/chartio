package com.mb30.chartio.app.svc;


import java.util.List;

public interface CoinQueryAppSvc {
    <T> T ping();
    
    <T> List<T> assetPlatforms();
}
