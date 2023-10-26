package jpamvcexam.model.entity;

import jpamvcexam.model.dto.EmpDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@Entity
public class BBB {
	@Id
	int id;
	private String username;
	// 연관관계 매핑
	@ManyToOne
	private EmpDTO a;
	
	public BBB() {
	}

	public BBB(String username, EmpDTO EmpVO) {
		this.username = username;
		a = EmpVO;
	}
}
