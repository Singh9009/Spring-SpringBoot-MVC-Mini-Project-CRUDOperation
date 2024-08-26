package in.spring.repository;

import in.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
