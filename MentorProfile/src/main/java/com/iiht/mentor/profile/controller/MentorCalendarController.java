package com.iiht.mentor.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.mentor.profile.model.MentorCalender;
import com.iiht.mentor.profile.repositorydao.MentorCalenderRepositoryDao;

@RestController
@RequestMapping("/v1")
public class MentorCalendarController {
	
	@Autowired
	MentorCalenderRepositoryDao calRepositoryDao;
	
	@PostMapping("/MentorCalendar")
	public MentorCalender saveMentorCalendar(@RequestBody MentorCalender mentorCalender){
		return calRepositoryDao.save(mentorCalender);
	}
	
	@GetMapping("/MentorCalendar/{mentorId}")
	public MentorCalender getMentorByMentorId(@PathVariable(value = "mentorId") int mentorId ){		
		return calRepositoryDao.findByMid(mentorId);
	}
	
	@GetMapping("/MentorCalendar")
	public List<MentorCalender> getMentorCalender(){		
		return calRepositoryDao.findAll();
	}

}
