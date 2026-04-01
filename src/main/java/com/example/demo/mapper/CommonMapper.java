package com.example.demo.mapper;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.model.Department;

public final class CommonMapper {

	public static DepartmentDto mapDepartmentToDto(Department dept) {
		if (dept == null) return null;
		return DepartmentDto
				.builder()
				.id(dept.getId())
				.deptName(dept.getDeptName())
				.build();
	}
	
	public static Department mapDepartmentTtoToEntity(DepartmentDto dept) {
		if (dept == null) return null;
		return Department
				.builder()
				.deptName(dept.getDeptName())
				.build();
	}
}
