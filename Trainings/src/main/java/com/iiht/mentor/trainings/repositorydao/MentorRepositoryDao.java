package com.iiht.mentor.trainings.repositorydao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.mentor.trainings.model.Mentor;


@Repository
public interface MentorRepositoryDao extends JpaRepository<Mentor, Long> {
	
	Optional<Mentor> findByUsername(String username);
    Boolean existsByUsername(String username);
    List<Mentor> findBySkillsNameContainingAndStartTimeLessThanAndEndTimeGreaterThan(String name, int startTime, int endTime);
    
   
	

}
