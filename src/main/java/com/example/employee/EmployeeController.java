package com.example.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/employeeo")
public class EmployeeController {
	@Autowired
	EmployeeService empSer;
    static Logger log=Logger.getLogger(EmployeeController.class);
    
    @PostMapping(value = "/insertEmployee")
	public String postEmployee(@RequestBody Employee e) {
		return empSer.postEmployee(e);
	}

	

	@PostMapping(value = "/insert")
	public String addEmployee(@RequestBody Employee e) {
		return empSer.addEmployee(e);
	}

	@PostMapping(value = "/inserts")
	public String addEmployees(@RequestBody List<Employee> el) {
		return empSer.addEmployees(el);
	}

	@GetMapping(value = "/getid/{n}")
	public Employee getEmpDetail(@PathVariable int n) {
		return empSer.getEmpDetail(n);
	}

	@GetMapping(value = "/getlist")
	public List<Employee> getAllEmployee() {
		return empSer.getAllEmployee();
	}

	@DeleteMapping(value = "/delete/{n}")
	public String getDelEmp(@PathVariable int n) {
		return empSer.getDelEmp(n);
	}

	@GetMapping(value = "/getBySalary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empSer.getBySalary(salary);
	}

	@GetMapping(value = "/getName/{age}")
	public List<String> getName(@PathVariable int age) {
		return empSer.getName(age);
	}

	@GetMapping(value = "/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return empSer.getByGender(gender);
	}

	@GetMapping(value = "/getSalary/{age}")
	public List<Integer> getByAge(@PathVariable int age) {
		return empSer.getByAge(age);
	}

	@GetMapping(value = "/getBySalary/{salary1}/{salary2}")
	public List<Employee> getBySalary(@PathVariable int salary1, @PathVariable int salary2) {
		return empSer.getBySalary(salary1, salary2);
	}

	@GetMapping(value = "/getSalaryAbove/{salary1}")
	public List<Employee> getSalaryAbove(@PathVariable int salary1) {
		return empSer.getSalaryAbove(salary1);
	}

	@GetMapping(value = "/getNameByAge/{age}")
	public List<String> getNameByAge(@PathVariable int age) {
		return empSer.getNameByAge(age);
	}

	@PostMapping(value = "/postByAge")
	public String postByAge(@RequestBody Employee e) throws AgeException, Exception {
		return empSer.postByAge(e);
	}
	@GetMapping(value="/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name)throws NameNotFoundException,Exception {
		return empSer.getByName(name);
	}
	RestTemplate rest=new RestTemplate();
	@GetMapping(value="getCarList")
	public List<CarEntity> getCarList(){
		ParameterizedTypeReference <List<CarEntity>> param = new ParameterizedTypeReference<List<CarEntity>>() {
		};
		String url="http://localhost:8081/car/getlist";
		
		ResponseEntity<List<CarEntity>> response=rest.exchange(url, HttpMethod.GET, null, param);
	 List<CarEntity> val=response.getBody();
	 return val;
	}
	
	
	
}
