package com.aht.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aht.entities.Project;

public interface ProjectRespository extends JpaRepository<Project, Integer> {

}
