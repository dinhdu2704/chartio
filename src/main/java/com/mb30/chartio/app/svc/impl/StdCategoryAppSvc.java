package com.mb30.chartio.app.svc.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mb30.chartio.app.cmd.CategoryCmd;
import com.mb30.chartio.app.svc.CategoryAppSvc;
import com.mb30.chartio.domain.model.coingecko.Category;
import com.mb30.chartio.domain.repo.CategoryRepo;

@Service
@Slf4j
public class StdCategoryAppSvc implements CategoryAppSvc {
	
	private final CategoryRepo categoryRepo;
	
	public StdCategoryAppSvc(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	@Override
	public Category create(CategoryCmd cmd) {
		log.info("Create Category - cmd: {}", cmd);
		return categoryRepo.create(toCategory(cmd));
	}
	
	@Override
	public List<Category> list() {
		return null;
	}
	
	private Category toCategory(CategoryCmd cmd) {
		return new Category()
				   .setCategoryId(cmd.getCategoryId())
				   .setName(cmd.getName());
	}
}
