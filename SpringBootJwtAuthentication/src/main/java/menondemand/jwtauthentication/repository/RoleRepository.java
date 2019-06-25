package menondemand.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import menondemand.jwtauthentication.model.Role;
import menondemand.jwtauthentication.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}