package in.spring.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emp")
@Data
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name="generator1", sequenceName = "empno_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "generator1", strategy = GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length = 10)
	private String ename;
	@Column(length = 10)
	private String job;
	@Column(name="sal")
	private Float salary;
	
}
