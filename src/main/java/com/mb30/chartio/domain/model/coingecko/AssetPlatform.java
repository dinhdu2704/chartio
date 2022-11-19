package com.mb30.chartio.domain.model.coingecko;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetPlatform {
	private String id;
	private String chainIdentifier;
	private String name;
	private String shortName;
}
