package com.mb30.chartio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	@Setter(AccessLevel.NONE)
	protected LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	@Setter(AccessLevel.NONE)
	protected LocalDateTime updatedAt;
}
