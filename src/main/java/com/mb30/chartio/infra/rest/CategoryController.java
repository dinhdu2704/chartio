package com.mb30.chartio.infra.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mb30.chartio.app.cmd.CategoryCmd;
import com.mb30.chartio.app.svc.CategoryAppSvc;
import com.mb30.chartio.domain.model.coingecko.Category;
import com.mb30.chartio.infra.rest.request.CategoryRequest;

@RestController
public class CategoryController {
	private final CategoryAppSvc categoryAppSvc;
	
	public CategoryController(CategoryAppSvc categoryAppSvc) {
		this.categoryAppSvc = categoryAppSvc;
	}
	
	@PostMapping("/category/create")
	public Category categoryCreate (@RequestBody @Valid CategoryRequest request) {
		return categoryAppSvc.create(toCategoryCmd(request));
	}
	
	@GetMapping("/category/list")
	public List<Category> categoryList() {
		return categoryAppSvc.list();
	}
	
	private CategoryCmd toCategoryCmd(CategoryRequest request) {
		return new CategoryCmd()
				   .setCategoryId(request.getCategoryId())
				   .setName(request.getName());
	}
}
