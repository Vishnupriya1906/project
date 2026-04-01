package com.example.demo.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DepartmentDto {

	private Long id;

	private String deptName;

	private Date createdOn;

	private Date updatedOn;
}