package com.aht.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table

public class Developer {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	
	@ManyToMany
	@JoinTable(name="developer_project",joinColumns= {@JoinColumn(name="developer_id")},inverseJoinColumns= {@JoinColumn(name="project_id")})
	
	private List<Project> projects;
	
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
	
	
	public List<Project> getProject() {
		return projects;
	}
	public void setProject(List<Project> projects) {
		this.projects = projects;
	}

	public Developer(String name, List<Project> projects) {
		
		this.name = name;
		this.projects = projects;
	}
	public Developer() {
		
	}
	public Developer(int id, String name, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.projects = projects;
	}
	
//	public Developer(String name) {
//
//		this.name = name;
//	}
//	
	
	
}
