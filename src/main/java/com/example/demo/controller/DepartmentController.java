
package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
	
	private final DepartmentService deptService;

	@GetMapping("/findAll")
	public ResponseEntity<ApiResponse<List<DepartmentDto>>> findAllDepartment(){
		ApiResponse<List<DepartmentDto>> response =  deptService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/createOrUpdate")
	public ResponseEntity<ApiResponse<DepartmentDto>> saveDepartment(@RequestBody DepartmentDto dept){
		ApiResponse<DepartmentDto> res = deptService.saveOrUpdate(dept);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
}
