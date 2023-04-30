package ta3ik.linkreduction.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ta3ik.linkreduction.model.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
}