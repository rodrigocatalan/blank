package br.com.ahrpius.blank.controller;

import static br.com.ahrpius.blank.validation.CustomMatchers.notEmpty;
import static org.hamcrest.Matchers.is;

import java.util.Calendar;
import java.util.List;

import br.com.ahrpius.blank.dao.OperatingSystemDao;
import br.com.ahrpius.blank.dao.ProjectDao;
import br.com.ahrpius.blank.interceptor.UserInfo;
import br.com.ahrpius.blank.model.OperatingSystem;
import br.com.ahrpius.blank.model.Project;
import br.com.ahrpius.blank.model.Server;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class ProjectsController {

	private final Result result;
	private final Validator validator;
	private final ProjectDao projectDao;
	private final UserInfo userInfo;
	private final OperatingSystemDao osDao;
	
	public ProjectsController(Result result, Validator validator,
			ProjectDao projectDao, UserInfo userInfo,
			OperatingSystemDao osDao) {
		this.result = result;
		this.validator = validator;
		this.projectDao = projectDao;
		this.userInfo = userInfo;
		this.osDao = osDao;
	}
	
	@Post("/projects")
	public void add(final Project project) {
		
		validator.checking(new Validations(){{
			if (project !=null) {
				that(project.getDescription(), is(notEmpty()), "description", "invalid_description");
			}
		}});
		
		validator.onErrorForwardTo(ProjectsController.class).list();
		
		project.setCreation(Calendar.getInstance());
		project.setOwner(userInfo.getUser());
		
		projectDao.add(project);
		
		result.include("notice", project.getDescription() + " project added");
		result.redirectTo(ProjectsController.class).list();
	}
	
	@Get("/projects")
	public void list() {
		
		List<Project> projects = projectDao.listAll();
		
		result.include("projects", projects);
	}
	
	@Get("/projects/{project.id}")
	public Project view(Project project) {
		List<OperatingSystem> oss = osDao.listAll();
		result.include("oss", oss);
		return projectDao.find(project.getId());
	}
	
	@Post("/projects/{project.id}/servers")
	public void addServer(final Server server, final Project project) {
		
		validator.checking(new Validations(){{
			if (server !=null) {
				that(server.getDescription(), is(notEmpty()), "description", "invalid_description");
				that(server.getIp(), is(notEmpty()), "ip", "invalid_ip");
			}
		}});
		
		validator.onErrorForwardTo(ProjectsController.class).addServer(server,project);
		
		Project p = projectDao.find(project.getId());
		
		server.setCreation(Calendar.getInstance());
		server.setOwner(userInfo.getUser());
		
		p.addServer(server);
		
		projectDao.add(p);
		
		result.include("notice", server.getDescription() + " server added");
		result.redirectTo(ProjectsController.class).view(project);
	}
	
	@Get("/projects/{project.id}/servers")
	public void viewServers(Project project) {
		Project projectDB = projectDao.find(project.getId());
	    result.include("servers", projectDB.getServers());
	}	
}
