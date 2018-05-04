package com.aht.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Developer;

@Repository
public interface DeveloperRespository extends JpaRepository<Developer, Integer> {
	
}
