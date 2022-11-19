package com.mb30.chartio.domain.model.coingecko;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mb30.chartio.domain.model.BaseEntity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = Category.TABLE_NAME)
public class Category extends BaseEntity {
	public static final String TABLE_NAME= "category";
	
	@Column(name = "category_id")
	private String categoryId;
	@Column(name = "name")
	private String name;
}
