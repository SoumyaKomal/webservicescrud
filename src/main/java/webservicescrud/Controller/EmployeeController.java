package webservicescrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import webservicescrud.Model.Employee;
import webservicescrud.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;


	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";

	}
	
	
	
	@GetMapping("/{id}")
	public String getEmployee(@PathVariable("{id}") long id, Model model) {
		 model.addAttribute("listEmployees", employeeService.getEmployeeById(id));
		 return "index";
		 
	}
	
	
	@GetMapping("/displayNewEmpForm")
	public String displayNewEmpForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";

	}

	
	@PostMapping("/saveEmployee")
    public String SaveEmployee(@ModelAttribute("employee")Employee employee) {
		      employeeService.saveEmployee(employee);
                return "redirect:/";
                
    }
	
	
	@GetMapping("/displayFormForUpdate/{id}")
    public String displayFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
        
    }
	
	@GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
        
    }

}
