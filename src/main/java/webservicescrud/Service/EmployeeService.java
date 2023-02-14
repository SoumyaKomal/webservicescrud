package webservicescrud.Service;

import java.util.List;

import webservicescrud.Model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);
	
    void saveEmployee(Employee employee);
	
	Employee getEmployeeById1(long id);

	void deleteEmployeeById(long id);

}
