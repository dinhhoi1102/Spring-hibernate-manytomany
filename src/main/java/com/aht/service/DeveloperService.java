package com.aht.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.Developer;
import com.aht.entities.Project;
import com.aht.respository.DeveloperRespository;
import com.aht.respository.ProjectRespository;

@Service
public class DeveloperService {

	@Autowired
	private DeveloperRespository deRespository;

	@Autowired
	private ProjectRespository projectRespository;
	// public List<Developer> getAllDevelopers(){
	// List<Developer> developers = deRespository.findAll();
	// for (Developer developer : developers) {
	// List<Project> projects = developer.getProject();
	// for(Project project : projects) {
	// project.setDevelopers(null);
	// }
	// }
	// return developers;
	//
	// }

	public Collection<Developer> getAllDeveloper() {
		return deRespository.findAll();
	}

	public Optional<Developer> findDeveloperById(int id) {
		return deRespository.findById(id);

	}

	public void createDeveloper(Developer dev) {
		Collection<Project> projectsOfDev = dev.getProject();
		Collection<Project> projects = dev.getProject();
		for (Project project : projects) {
			for (Project projectOfDev : projectsOfDev) {
				if (projectOfDev.equals(project)) {
					projectOfDev = null;
				}
			}
		}
		deRespository.save(dev);
	}

	public void deleteDeveloper(int id) {

		deRespository.deleteById(id);
	}

	public void editDeveloper(Developer st) {
		deRespository.save(st);
	}

	public List<Developer> getDeveloperFollowProject(int id) {
		List<Developer> developers = deRespository.findAll();
		List<Developer> deList = new ArrayList<>();
		List<Project> listProject;
		for (Developer developer : developers) {
			listProject = developer.getProject();
			for (Project project : listProject) {
				if (project.getId() == id) {
					System.out.println(project);
					System.out.println(developer);
					deList.add(developer);
				}
			}
		}
		return deList;

	}
}
