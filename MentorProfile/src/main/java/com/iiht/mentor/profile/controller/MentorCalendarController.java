package com.iiht.mentor.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.mentor.profile.repositorydao.MentorCalenderRepositoryDao;
import com.iiht.mentor.profile.repositorydao.MentorSkillRepositoryDao;

@RestController
@RequestMapping("/v1")
public class MentorCalendarController {
	
	@Autowired
	MentorCalenderRepositoryDao calRepositoryDao;
	
	@GetMapping("/MentorCalendar/{mentorId}")
	public List<MentorSkillRepositoryDao>getMentorCalendar(){
		return null;
	}
	
	@GetMapping("/CheckMentorAvailability/{mentorId}")
	public List<MentorSkillRepositoryDao>checkMentorAvailability(){		
		return null;
	}

}
