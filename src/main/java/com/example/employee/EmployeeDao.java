package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRep;
	

	public String postEmployee(@RequestBody Employee e) {
		 empRep.save(e);
		 return "posted";
	}

	public String addEmployee(Employee e) {

		empRep.save(e);
		return "successfully";
	}

	public String addEmployees(List<Employee> el) {
		empRep.saveAll(el);
		return "succefully saved";
	}

	public Employee getEmpDetail( int n) {
		return empRep.findById(n).get();
	}

	public List<Employee> getAllEmployee() {
		return empRep.findAll();
	}

	public String getDelEmp( int n) {
		 empRep.deleteById(n);
         return "deleted";
	}
	public List<Employee> getBySalary(int salary1,int salary2){
		return empRep. getBysalary(salary1,salary2);
	}
	public List<Employee> getSalaryAbove(int salary1){
             return empRep.getSalaryAbove( salary1);
	}
	public List<String> getNameByAge(int age){
		return empRep.getNameByAge(age);
	}
	public String postByAge(Employee e)throws AgeException,Exception {
		 empRep.save(e);
		 return "successfull";
		 }
	public List<Employee> getByName(String name) {
		return empRep.getByName(name);
	}
	}

