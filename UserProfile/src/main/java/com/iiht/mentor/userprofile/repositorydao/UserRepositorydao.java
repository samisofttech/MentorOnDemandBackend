package com.iiht.mentor.userprofile.repositorydao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.mentor.userprofile.model.UserProfileEntity;
@Repository
public interface UserRepositorydao extends JpaRepository<UserProfileEntity, Long>{
	
	 	Optional<UserProfileEntity> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
	    Optional<UserProfileEntity> findByUsernameAndConfirmCode(String username, String confirmCode);
	    Optional<UserProfileEntity> findByUsernameAndActive(String username, boolean active);

}
