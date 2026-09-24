package devshowcase_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import devshowcase_api.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}