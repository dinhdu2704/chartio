package com.mb30.chartio.infra.jpa;

import org.springframework.stereotype.Repository;

import com.mb30.chartio.domain.model.coingecko.Category;
import com.mb30.chartio.domain.repo.CategoryRepo;

@Repository
public class JpaCategoryRepo implements CategoryRepo {
	
	private final SpringCategoryRepo springCategoryRepo;
	
	public JpaCategoryRepo(SpringCategoryRepo springCategoryRepo) {
		this.springCategoryRepo = springCategoryRepo;
	}
	
	@Override
	public Category create(Category category) {
		return springCategoryRepo.save(category);
	}
}
