package com.mb30.chartio.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb30.chartio.domain.model.coingecko.Category;

@Repository
public interface SpringCategoryRepo extends JpaRepository<Category, Long> {
}
