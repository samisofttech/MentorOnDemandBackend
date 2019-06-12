package com.iiht.mentor.trainings.repositorydao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.mentor.trainings.model.TrainingStatus;
import com.iiht.mentor.trainings.model.Trainings;



@Repository
public interface TrainingsRepositoryDao extends JpaRepository<Trainings, Long>{
		List<Trainings> findByMentorId(long mentorid);
		List<Trainings> findByUserId(Long userid);
		List<Trainings> findByStatus(TrainingStatus status);

}