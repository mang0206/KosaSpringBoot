package jpamvcexam.model.entity;

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
public class AAA {
	@Id
	int id;
	private String username;
	// 연관관계 매핑
	@ManyToOne
	private Team a;
	
	public AAA() {
	}
	public AAA(String username, Team team) {
		this.username = username;
		a = team;
	}
}
