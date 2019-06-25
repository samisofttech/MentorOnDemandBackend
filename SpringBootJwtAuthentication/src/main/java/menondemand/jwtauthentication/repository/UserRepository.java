package menondemand.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.mentor.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsernameAndConfirmCode(String username, String confirmCode);
    Optional<User> findByUsernameAndActive(String username, boolean active);
   
}