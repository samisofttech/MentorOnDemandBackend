package com.iiht.mentor.profile.repositorydao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.mentor.profile.model.Mentor;


@Repository
public interface MentorRepositoryDao extends JpaRepository<Mentor, Integer> {
	
	Optional<Mentor> findByUsername(String username);
    
   
	

}
