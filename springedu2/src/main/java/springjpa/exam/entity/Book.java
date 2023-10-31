package springjpa.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratedColumn;

@Entity
@Setter
@Getter
@ToString
public class Book {
  @Id
  private int id;
  private String title;
  private int price;
  private String kind;
}
