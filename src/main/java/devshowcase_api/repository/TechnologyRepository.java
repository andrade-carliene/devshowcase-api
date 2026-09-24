package devshowcase_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import devshowcase_api.model.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

}