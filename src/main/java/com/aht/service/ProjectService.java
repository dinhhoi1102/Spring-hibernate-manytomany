package com.aht.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.Developer;
import com.aht.entities.Project;
import com.aht.respository.ProjectRespository;


@Service
public class ProjectService {

	@Autowired
	private ProjectRespository projectService;

//	public List<Project> getAllProject(){
//		
//		List<Project> projects = projectService.findAll();
//		
//		for (Project project : projects) {
//			List<Developer> developers = project.getDevelopers();
//			for(Developer developer : developers) {
//				developer.setProject(null);
//			}
//		}
//		return projects;
//	}
	public List<Project> getAllProject() {

		return projectService.findAll();	
	}

	public Optional<Project> findProjectById(int id) {
		return projectService.findById(id);

	}

	public void createProject(Project st) {
		projectService.save(st);

	}
  
	public void deleteProject(int id) {
		projectService.deleteById(1);
	}
	
	public void editProject(Project st) {
		projectService.save(st);
	}

	
//	public Developer createDeveloper(Developer d) {
//		
//	}
}
