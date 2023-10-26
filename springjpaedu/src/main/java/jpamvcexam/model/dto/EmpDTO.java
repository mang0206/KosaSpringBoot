package jpamvcexam.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
@Getter
@Setter
@ToString
public class EmpDTO {
	@Id
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private java.sql.Date  hiredate;
	private int sal;
	private Integer comm;
	private Integer deptno;
}
