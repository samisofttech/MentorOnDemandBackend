package menondemand.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.mentor.model.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
	
	
    Optional<Mentor> findByUsername(String username);
    Boolean existsByUsername(String username);
   // List<Mentor> findBySkillsNameContainingAndStartTimeLessThanAndEndTimeGreaterThan(String name, int startTime, int endTime);
    

}
