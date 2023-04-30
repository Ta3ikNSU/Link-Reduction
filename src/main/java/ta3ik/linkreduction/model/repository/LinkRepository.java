package ta3ik.linkreduction.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ta3ik.linkreduction.model.entity.Link;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findById(Long id);

    Link findByKey(String key);

    Optional<Link> findTopByOrderByIdDesc();
}