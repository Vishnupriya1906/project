package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.CommonMapper;
import com.example.demo.model.Department;
import com.example.demo.repo.DepartmentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepo departmentRepo;

	public ApiResponse<List<DepartmentDto>> findAll() {

		List<Department> deparments = departmentRepo.findAll();

		if (deparments.isEmpty()) {
			throw new ResourceNotFoundException("Departments Not Exists");
		}

		List<DepartmentDto> departmentsDto = deparments.stream().map(dept -> CommonMapper.mapDepartmentToDto(dept))
				.toList();

		return ApiResponse.<List<DepartmentDto>>builder().statusCode(200).message("Department Fetched Successfully")
				.data(departmentsDto).build();
	}

	public ApiResponse<DepartmentDto> saveOrUpdate(DepartmentDto dept) {

		if (dept == null)
			throw new IllegalArgumentException("All Fields are Required");

		boolean isUpdate = dept.getId() != null;
		Department department = null;

		Department mapped = CommonMapper.mapDepartmentTtoToEntity(dept);

		if (isUpdate) {
			department = departmentRepo.findById(dept.getId()).orElseThrow(
					() -> new ResourceNotFoundException("Department with id " + dept.getId() + " not found"));

			mapped.setCreatedOn(department.getCreatedOn());
			mapped.setId(department.getId());

		}

		Department saved = departmentRepo.save(mapped);

		DepartmentDto dto = CommonMapper.mapDepartmentToDto(saved);

		return ApiResponse.<DepartmentDto>builder().message(isUpdate ? "Updated" : "Saved")
				.statusCode(isUpdate ? 200 : 201).data(dto).build();
	}

}
