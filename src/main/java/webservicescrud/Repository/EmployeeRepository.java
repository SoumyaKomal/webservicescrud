package webservicescrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webservicescrud.Model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
