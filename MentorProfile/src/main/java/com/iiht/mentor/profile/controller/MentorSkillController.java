package com.iiht.mentor.profile.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iiht.mentor.profile.model.Mentor;
import com.iiht.mentor.profile.model.MentorCalender;
import com.iiht.mentor.profile.model.MentorSkill;
import com.iiht.mentor.profile.model.Skills;
import com.iiht.mentor.profile.repositorydao.MentorCalenderRepositoryDao;
import com.iiht.mentor.profile.repositorydao.MentorRepositoryDao;
import com.iiht.mentor.profile.repositorydao.MentorSkillRepositoryDao;


@RestController
@RequestMapping("/v1")
public class MentorSkillController {

	@Autowired
	MentorSkillRepositoryDao mentorSkillRepositoryDao;

	@Autowired
	MentorCalenderRepositoryDao calRepositoryDao;
	
	@Value("${skillrepo.url}")
	private String skillRepoURL;

	@Autowired
	private MentorRepositoryDao mentorRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/mentorSkills/mentor/{mentorId}")
	public List<MentorSkill> getMentorSkills(@PathVariable("mentorId") int mentorId) {
		return 	mentorSkillRepositoryDao.findByMid(mentorId);
	}

	@PutMapping("/mskill/{mid}/{sid}")
	public ResponseEntity<MentorSkill> updateSkill(@PathVariable("mid") int mid, @PathVariable("sid") int sid,
			@RequestBody MentorSkill mentorSkill) {
		System.out.println("Update Mentor Skill with mentorId = " + mid + " and skillId = " + sid);

		Optional<MentorSkill> mentorSkills = mentorSkillRepositoryDao.findById(mid);

		if (mentorSkills.isPresent()) {
			MentorSkill _mentorSkills = mentorSkills.get();
			_mentorSkills.setYears_of_exp(mentorSkill.getYears_of_exp());
			_mentorSkills.setTrainings_delivered(mentorSkill.getTrainings_delivered());

			mentorSkillRepositoryDao.save(_mentorSkills);
			return new ResponseEntity<>(_mentorSkills, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/mentorSkills")
	public List<MentorSkill> getMentorSkills() {
		return mentorSkillRepositoryDao.findAll();
	}

	@PostMapping("/mentorSkill")
	public MentorSkill createMentorSkill(@RequestBody MentorSkill mentorSkill) {
		return mentorSkillRepositoryDao.save(mentorSkill);
	}

	@GetMapping("/mentorSkill/{skillId}")
	public List<MentorSkill> getMentorSkillBySkilId(@PathVariable(name = "skillId") int skillId) {
		return mentorSkillRepositoryDao.findBySid(skillId);
	}

	@GetMapping("/mentorSkills/{skillName}")
	public List<MentorSkill> getMentorSkillBySkillName(@PathVariable(name = "skillName") String skillName) {
		ResponseEntity<Skills> existingSkill = restTemplate.getForEntity(skillRepoURL+"/v1/searchskill/"+skillName, Skills.class);
		if(existingSkill.getBody()!=null) {
			return mentorSkillRepositoryDao.findBySid(existingSkill.getBody().getId());
		}
		return null;
	}

	@GetMapping("/mentorSkill/{skillName}/{mentorDate}")
	public List<Mentor> getMentorSkillBySkilIdAndDate(@PathVariable(name = "skillName") String skillName
			, @PathVariable(name="mentorDate") @DateTimeFormat(pattern="yyyy-MM-dd")  Date availableDate) {
		List<Mentor> mentors = null;
		ResponseEntity<Skills> existingSkill = restTemplate.getForEntity(skillRepoURL+"/v1/searchskill/"+skillName, Skills.class);
		
		if(existingSkill.getBody()!=null) {
			List<MentorSkill> mentorSkills = mentorSkillRepositoryDao.findBySid(existingSkill.getBody().getId());
			mentors = mentorSkills.stream().map(mentorSkill->{
				MentorCalender calender = calRepositoryDao.findByMid(mentorSkill.getMid());
				if(availableDate.after(calender.getStart_date())) {
					return mentorRepo.findById(mentorSkill.getMid()).get();
				}
				return null;
				
			}).collect(Collectors.toList());
			
		}
		return mentors;
	}
}
