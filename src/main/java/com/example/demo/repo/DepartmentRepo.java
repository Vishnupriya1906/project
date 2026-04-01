package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.model.Department;

public interface DepartmentRepo extends JpaRepository<Department,Long>,JpaSpecificationExecutor<Department>{

}
