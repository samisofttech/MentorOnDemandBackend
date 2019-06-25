package com.iiht.mentor.trainings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iiht.mentor.trainings.model.Trainings;
import com.iiht.mentor.trainings.repositorydao.TrainingsRepositoryDao;

@RestController
@RequestMapping("/trainings")
public class TrainingsController {
	 
	 @Autowired
	 RestTemplate restTemplate;
	 
	 @Value("${userrepo.url}")
	 private String userRepoURL;
	 
	 @Value("${mentorepo.url}")
	 private String mentorRepoURl;
	 
	 @Value("${skillrepo.url}")
	 private String skillRepoURL;
	 
	 
	@Autowired
	TrainingsRepositoryDao trainingsRepositoryDao;
		
	@PostMapping("/Training")
	public Trainings createTraining(@RequestBody Trainings training){
		return trainingsRepositoryDao.save(training);
	}
	
	@GetMapping("/TrainingDetails")
	public List<TrainingsRepositoryDao> getTrainingDetails(){
		
		return null;
	}
	
	@GetMapping("/TrainingCompleted")
	public List<TrainingsRepositoryDao> getCompletedTrainings(){
		
		return null;//TODO
	}
	
	@GetMapping("/TrainingInProgress")
	public List<TrainingsRepositoryDao> getUnderProgressTrainings(){
		return null;//TODO
		
	}
	
	
	@GetMapping("/TrainingProposed")
	public List<TrainingsRepositoryDao> proposeTraining(){
		return null;//TODO
		
		
	}
	
	@GetMapping("/TrainingApproved")
	public List<TrainingsRepositoryDao> approveTraining(){
		return null;//TODO
		
		
	}
	
	@GetMapping("/TrainingFinalized")
	public List<TrainingsRepositoryDao> finalizeTraining(){
		return null;//TODO
		
		
	}
	

}
