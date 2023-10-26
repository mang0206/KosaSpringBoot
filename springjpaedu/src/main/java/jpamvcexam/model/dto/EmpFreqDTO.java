package jpamvcexam.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpFreqDTO {
	private int empno;
	private String ename;
	private java.util.Date  hiredate;
	private int sal;
	private Integer deptno;
}
