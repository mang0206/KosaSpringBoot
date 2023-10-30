package springjpa.exam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Team {
	@Id
	@Column(name = "TEAM_ID")	
	private String id;
	private String name;
	public Team() {
	}
	public Team(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
