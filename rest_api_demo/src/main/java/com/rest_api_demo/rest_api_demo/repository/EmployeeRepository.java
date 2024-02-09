package com.rest_api_demo.rest_api_demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rest_api_demo.rest_api_demo.model.Employee;

//@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
