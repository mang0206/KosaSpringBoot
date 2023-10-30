package jpamvcexam.model.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
public class Dept {
  @Id
  private int deptno;
  private String dname;
  private String loc_code;
}
