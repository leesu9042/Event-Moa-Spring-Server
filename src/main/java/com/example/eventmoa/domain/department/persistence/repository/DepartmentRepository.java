package com.example.eventmoa.domain.department.persistence.repository;

import com.example.eventmoa.domain.department.persistence.Department;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    List<Department> findAllByOrderByDateAscTimeAscDepartmentAsc();
}
