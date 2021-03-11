package com.vivid.vtt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivid.vtt.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long>{

	public List<Skill> findAll();
}
