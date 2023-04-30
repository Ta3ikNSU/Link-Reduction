package ta3ik.linkreduction.model.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "KEY", nullable = false)
    String key;

    @Column(name = "URL", nullable = false)
    String url;

    public Link(String key, String url) {
        this.key = key;
        this.url = url;
    }
}