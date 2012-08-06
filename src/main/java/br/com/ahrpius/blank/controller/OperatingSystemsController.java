package br.com.ahrpius.blank.controller;

import static br.com.ahrpius.blank.validation.CustomMatchers.notEmpty;
import static org.hamcrest.Matchers.is;

import java.util.Calendar;
import java.util.List;

import br.com.ahrpius.blank.dao.OperatingSystemDao;
import br.com.ahrpius.blank.interceptor.UserInfo;
import br.com.ahrpius.blank.model.OperatingSystem;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class OperatingSystemsController {

	private final Result result;
	private final Validator validator;
	private final OperatingSystemDao dao;
	private final UserInfo userInfo;
	
	public OperatingSystemsController(Result result, Validator validator,
			OperatingSystemDao operatingSystemDao, UserInfo userInfo) {
		this.result = result;
		this.validator = validator;
		this.dao = operatingSystemDao;
		this.userInfo = userInfo;		
	}
	
	@Get("/operatingSystems")
	public List<OperatingSystem> list() {
		
		List<OperatingSystem> oss = dao.listAll();
		
		return oss;
	}
	
	@Post("/operatingSystems")
	public void add(final OperatingSystem operatingSystem) {
		
		validator.checking(new Validations(){{
			if (operatingSystem !=null) {
				that(operatingSystem.getDescription(), is(notEmpty()), "description", "invalid_description");
			}
		}});
		
		validator.onErrorForwardTo(OperatingSystemsController.class).list();
		
		operatingSystem.setCreation(Calendar.getInstance());
		operatingSystem.setOwner(userInfo.getUser());
		
		dao.add(operatingSystem);
		
		result.include("notice", operatingSystem.getDescription() + " O.S. added");
		result.redirectTo(OperatingSystemsController.class).list();
	}
}
