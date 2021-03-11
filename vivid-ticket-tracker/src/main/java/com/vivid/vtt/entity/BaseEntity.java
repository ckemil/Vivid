package com.vivid.vtt.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	
	@CreatedDate
	private LocalDateTime creationDate;
	@LastModifiedDate
	private LocalDateTime updationDate;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String updatedBy;
	

}
