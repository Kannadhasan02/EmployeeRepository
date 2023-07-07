package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

@Query(value="select * from employee where salary>=? AND salary<=?",nativeQuery=true)
public List<Employee> getBysalary(int salary1,int salary2);
@Query(value="select*from employee where salary>=?",nativeQuery=true)
public List<Employee> getSalaryAbove(int salary1);
@Query(value="select name from employee where age>=?",nativeQuery=true)
public List<String> getNameByAge(int age);
@Query(value="select * from employee where  like ?",nativeQuery=true)
public List<Employee> getByName(String name);
}
