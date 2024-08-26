package in.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.model.Employee;
import in.spring.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtservice implements IEmployeeMgmtservice {

	@Autowired
	private IEmployeeRepository empRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}

	@Override
	public String registerEmployee(Employee employee) {
		//save employee and get employee number
		int idValue = empRepository.save(employee).getEmpno();
		return "Employee Register with ID "+idValue;
	}

	@Override
	public Employee getEmployeeByNo(int empNo) {
		Employee employee = empRepository.findById(empNo).get();
		return employee;
	}

	@Override
	public String editEmployee(Employee employee) {
		int idValue = empRepository.save(employee).getEmpno();
		return "Employee number "+idValue+ " is updated";
	}

	@Override
	public String deleteEmployee(int empNo) {
		empRepository.deleteById(empNo);
		return "Employee ID "+empNo+" is deleted";
	}

}
