/**
 * 
 */
package com.iiht.mentor.skills.technologies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.mentor.skills.technologies.model.SkillsTechnologiesEntity;
import com.iiht.mentor.skills.technologies.repositorydao.SkillsTechnologiesRepositorydao;

@RestController
@RequestMapping("/v1")
public class SkillsTechnologiesController {
	
	@Autowired
	SkillsTechnologiesRepositorydao skillsTechnologiesRepositorydao;
	
	
	@GetMapping("/skill/{id}")
	public SkillsTechnologiesEntity getSkillById(@PathVariable(value = "id") int id){
		return skillsTechnologiesRepositorydao.findById(id).get();
	}
	
	@GetMapping("/skills")
	public List<SkillsTechnologiesEntity> getAllSkills(){
		return skillsTechnologiesRepositorydao.findAll();
	}
	
	@GetMapping("/searchskill/{skillName}")
	public SkillsTechnologiesEntity searchSkills(@PathVariable(value = "skillName") String skillName){
		return getAllSkills().stream().filter(skill -> skill.getSkillname().equalsIgnoreCase(skillName)).findAny().orElse(null);
	}
	
	@PostMapping("/createskills")
	public List<SkillsTechnologiesEntity> createSkills(@RequestBody List<SkillsTechnologiesEntity> skills){
		if(!CollectionUtils.isEmpty(skills)) {
		return skills.stream().map(skill ->{
				return createSkill(skill);
			}).collect(Collectors.toList());
		}
		return null;
	}
	
	@PostMapping("/createskill")
	public SkillsTechnologiesEntity createSkill(@RequestBody SkillsTechnologiesEntity skill){
		return skillsTechnologiesRepositorydao.save(skill);
	}

}
