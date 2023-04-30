package ta3ik.linkreduction.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "link")
@ToString
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "key", nullable = true)
    private String key;

    @Column(name = "url", nullable = false)
    private String url;

    public Link(String url) {
        this.url = url;
    }
}