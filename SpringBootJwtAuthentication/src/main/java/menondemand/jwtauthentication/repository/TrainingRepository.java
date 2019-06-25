package menondemand.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import menondemand.jwtauthentication.model.Trainings;

@Repository
public interface TrainingRepository extends JpaRepository<Trainings, Long> {
	List<Trainings> findByMentorId(long mentorid);
	List<Trainings> findByUserId(long userid);
}