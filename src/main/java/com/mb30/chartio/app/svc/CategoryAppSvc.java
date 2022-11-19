package com.mb30.chartio.app.svc;

import java.util.List;

import com.mb30.chartio.app.cmd.CategoryCmd;
import com.mb30.chartio.domain.model.coingecko.Category;

public interface CategoryAppSvc {
	Category create(CategoryCmd cmd);
	
	List<Category> list();
}
