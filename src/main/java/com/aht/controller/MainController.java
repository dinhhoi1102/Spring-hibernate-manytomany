package com.aht.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aht.entities.Developer;
import com.aht.entities.Project;
import com.aht.service.DeveloperService;
import com.aht.service.ProjectService;

@RestController
public class MainController {
	
	@Autowired
	private DeveloperService developerService;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping(value="/developers")
	public ResponseEntity<Collection<Developer>> getAllDeveloper(){
		Collection<Developer> developers = developerService.getAllDeveloper();
		System.out.println(developers);
		return new ResponseEntity<Collection<Developer>>(developers,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/developers/{id}")
	public ResponseEntity<Optional<Developer>> getDeveloperById(@PathVariable int id){
		
		return new ResponseEntity<Optional<Developer>>((developerService.findDeveloperById(id)),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/developers")
	public ResponseEntity<String> createDeveloper(@RequestBody Developer dev){
		developerService.createDeveloper(dev);
		return new ResponseEntity<String>("created",HttpStatus.OK);
	}
	
	@DeleteMapping(value="developers/{id}")
	public ResponseEntity<String> deleteDeveloper(@PathVariable int id){
		developerService.deleteDeveloper(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	
	@GetMapping(value="/projects")
	public ResponseEntity<List<Project>> getAllProject(){
		List<Project> developers = projectService.getAllProject();
		System.out.println(developers);
		return new ResponseEntity<List<Project>>(developers,HttpStatus.OK);
	}
	
	///tim kiem theo id project cac developer lam
	
	@GetMapping(value="/developersf/{oo}")
	public ResponseEntity<List<Developer>> getDeveloperDoProject(@PathVariable("oo") int id){
		System.out.println(id);
		return new ResponseEntity<List<Developer>>(developerService.getDeveloperFollowProject(id),HttpStatus.OK);
	}
}
