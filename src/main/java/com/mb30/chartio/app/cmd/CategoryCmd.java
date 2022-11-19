package com.mb30.chartio.app.cmd;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CategoryCmd {
	private String categoryId;
	private String name;
}
