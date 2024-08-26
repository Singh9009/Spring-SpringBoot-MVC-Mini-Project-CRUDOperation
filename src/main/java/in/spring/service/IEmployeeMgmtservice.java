package in.spring.service;

import java.util.List;

import in.spring.model.Employee;

public interface IEmployeeMgmtservice {

	public List<Employee> getAllEmployee();
	public String registerEmployee(Employee employee);
	public Employee getEmployeeByNo(int empNo);
	public String editEmployee(Employee employee);
	public String deleteEmployee(int empNo);
}
