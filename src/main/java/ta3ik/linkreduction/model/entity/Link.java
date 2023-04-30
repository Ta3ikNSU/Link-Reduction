package ta3ik.linkreduction.model.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    @Id
    @Column(name = "ID")
    Long id;

    @Column(name = "KEY", nullable = false)
    String key;

    @Column(name = "URL", nullable = false)
    String url;
}