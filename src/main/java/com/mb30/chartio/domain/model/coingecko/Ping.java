package com.mb30.chartio.domain.model.coingecko;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ping {
	@JsonProperty(value = "gecko_says")
	String geckoSays;
}
