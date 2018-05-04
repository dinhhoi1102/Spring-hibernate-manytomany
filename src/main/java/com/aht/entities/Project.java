package com.aht.entities;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table

public class Project  {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	 
	@ManyToMany(mappedBy="projects")
	private List<Developer> developers;

	@JsonIgnore
	public List<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Project(String name, List<Developer> developers) {
		
		this.name = name;
		this.developers = developers;
	}
	public Project() {
		
		
	}
//	public Project(String name) {
//	
//		this.name = name;
//	}

	
}
