package in.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.spring.model.Employee;
import in.spring.service.IEmployeeMgmtservice;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtservice service;
	
	@GetMapping("/")
	public String showHomePage()
	{
		return "home";
	}
	
	@GetMapping("/report")
	public String displayEmployeeReport(Map<String, Object> map)
	{
		//Use service here
		List<Employee> empsData = service.getAllEmployee();
		//System.out.println(empList);
		//put the result in the model attribute
		map.put("empsData", empsData);
		//return LVN;
		return "employee_report";
	}
	
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("employee")Employee employee)
	{
		//Return LVN
		return "employee_register_form";
	}
	
	/*@PostMapping("/add")
	public String addEmployee(Map<String, Object> map, @ModelAttribute("employee")Employee employee)
	{
		//Use service
		String result = service.registerEmployee(employee);
		List<Employee> list = service.getAllEmployee();
		//Keep result in modal attribute
		//map.put("empsData", list);
		map.put("resultMsg", result);
		//Return LVN
		return "employee_report";
	}*/
	
	//This method solved the double posting problem but didn't show result message.
	
	/*@PostMapping("/add")
	public String addEmployee(Map<String, Object> map, @ModelAttribute("employee")Employee employee)
	{
		//Use service
		String result = service.registerEmployee(employee);
		List<Employee> list = service.getAllEmployee();
		//Keep result in modal attribute
		//map.put("empsData", list);
		map.put("resultMsg", result);
		//Return LVN
		return "redirect:report";
	}*/
	
	
  //This method solved the double posting problem but msg will remove while refresh.
	
	/*@PostMapping("/add")
	public String addEmployee(RedirectAttributes attribute, @ModelAttribute("employee")Employee employee)
	{
		//Use service
		String result = service.registerEmployee(employee);
		List<Employee> list = service.getAllEmployee();
		//Keep result in modal attribute
		//map.put("empsData", list);
		attribure.addFlashAttribute("resultMsg", result);
		//Return LVN
		return "redirect:report";
	}*/
	
    //This method solved the double posting problem  and the msg didn't remove while click on refresh button.
	
	@PostMapping("/add")
	public String addEmployee(HttpSession session, @ModelAttribute("employee")Employee employee)
	{
		//Use service
		String result = service.registerEmployee(employee);
		List<Employee> list = service.getAllEmployee();
		//Keep result in modal attribute
		//map.put("empsData", list);
		session.setAttribute("resultMsg", result);
		//Return LVN
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String showEmployeeEditPage(@RequestParam("no")int no, @ModelAttribute("employee")Employee employee)
	{
		//use service here
		Employee emp = service.getEmployeeByNo(no);
		//employee=emp
		BeanUtils.copyProperties(emp, employee);
		return "employee_edit";
	}
	
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("employee")Employee employee,
			                   RedirectAttributes attribute)
	{
		//use service
		String message = service.editEmployee(employee);
		//List<Employee> empList = service.getAllEmployee();
		//Keeps data in model attribute
		//map.put("empsData", empList);
		attribute.addFlashAttribute("resultMsg", message);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no")int no, RedirectAttributes attrs)
	{
		//user service
		String resultMsg = service.deleteEmployee(no);
		//Keeps result in flash attribute in Redirect scope
		attrs.addFlashAttribute("resultMsg", resultMsg);
		return "redirect:report";
	}
	
}
