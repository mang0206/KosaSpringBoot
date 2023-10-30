package jpamvcexam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Emp {
  @Id
  private int empno;
  private String ename;
  private String job;
  private String mgr;
  private java.sql.Date  hiredate;
  private int sal;
  private Integer comm;
  @ManyToOne
  @JoinColumn(name="deptno")
  private Dept dept;
}
