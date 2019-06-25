package com.iiht.mentor.skills.technologies.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.mentor.skills.technologies.model.SkillsTechnologiesEntity;


@Repository
public interface SkillsTechnologiesRepositorydao extends JpaRepository<SkillsTechnologiesEntity, Integer>{

}
