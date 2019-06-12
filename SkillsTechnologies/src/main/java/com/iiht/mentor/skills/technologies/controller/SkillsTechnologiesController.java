/**
 * 
 */
package com.iiht.mentor.skills.technologies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.mentor.skills.technologies.repositorydao.SkillsTechnologiesRepositorydao;

@RestController
@RequestMapping("/v1")
public class SkillsTechnologiesController {
	
	@Autowired
	SkillsTechnologiesRepositorydao skillsTechnologiesRepositorydao;
	
	
	
	@GetMapping("/skill")
	public List<SkillsTechnologiesRepositorydao>getSkill(){
		
		return null;
	}
	
	@GetMapping("/searchskill")
	public List<SkillsTechnologiesRepositorydao>searchSkills(){
		
		return null;
	}

}
