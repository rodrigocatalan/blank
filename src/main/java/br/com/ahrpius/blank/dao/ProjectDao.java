package br.com.ahrpius.blank.dao;

import java.util.List;

import br.com.ahrpius.blank.model.Project;

public interface ProjectDao {
	
	void add(Project project);

	List<Project> listAll();

	Project find(Long id);
	
}
