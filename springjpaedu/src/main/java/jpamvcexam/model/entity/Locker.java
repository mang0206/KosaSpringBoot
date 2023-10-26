package jpamvcexam.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Locker {
    @Id
    @Column(name = "LOCKER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Locker(String name) {
        this.name = name;
    }
}
