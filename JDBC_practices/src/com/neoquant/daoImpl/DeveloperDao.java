package com.neoquant.daoImpl;

import java.util.List;

import com.neoquant.pojo.Developer;

public interface DeveloperDao {

	public boolean addDeveloper(Developer dev);
	public boolean updateDeveloper(Developer dev);
	public List<Developer> getAllDevelopers();
	public boolean deleteDeveloper(int id);
}
