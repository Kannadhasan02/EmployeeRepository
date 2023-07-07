package com.example.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
	
	
		public String postEmployee(@RequestBody Employee e) {
			return empDao.postEmployee(e);
		}

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public String addEmployees(List<Employee> el) {
		return empDao.addEmployees(el);
	}

	public Employee getEmpDetail(@PathVariable int n) {
		return empDao.getEmpDetail(n);
	}

	public List<Employee> getAllEmployee() {
		return empDao.getAllEmployee();
	}

	public String getDelEmp(@PathVariable int n) {
		return empDao.getDelEmp(n);
	}

	public List<Employee> getBySalary(int salary) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter((x) -> x.getSalary() > salary).collect(Collectors.toList());
	}

	public List<String> getName(int age) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter((x) -> x.getAge() > age).map(y -> y.getName()).collect(Collectors.toList());
	}

	public List<Employee> getByGender(String gender) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter(x -> x.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
	}

	public List<Integer> getByAge(int age) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter(x -> x.getAge() > 27).map(y -> y.getSalary()).toList();

	}

	public List<Employee> getBySalary(int salary1, int salary2) {
		return empDao.getBySalary(salary1, salary2);
	}

	public List<Employee> getSalaryAbove(int salary1) {
		return empDao.getSalaryAbove(salary1);
	}

	public List<String> getNameByAge(int age) {
		return empDao.getNameByAge(age);
	}

	public String postByAge( Employee e) throws AgeException, Exception {
	
		if (e.getAge() < 18) {
			throw new AgeException("you are not eligibile");
		} else {
			return empDao.postByAge(e);
		}
	}
	public List<Employee> getByName(String name)throws NameNotFoundException,Exception {
		if(empDao.getByName(name).isEmpty()) {
			throw new NameNotFoundException("name not Available");
		}
		else {
			return empDao.getByName(name);
		}
	}
}
