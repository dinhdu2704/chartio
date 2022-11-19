package com.mb30.chartio.infra.rest.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryRequest {
	@NotBlank
	private String categoryId;
	@NotBlank
	private String name;
}
