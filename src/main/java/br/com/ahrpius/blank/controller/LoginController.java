package br.com.ahrpius.blank.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import br.com.ahrpius.blank.dao.UserDao;
import br.com.ahrpius.blank.interceptor.Public;
import br.com.ahrpius.blank.interceptor.UserInfo;
import br.com.ahrpius.blank.model.User;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class LoginController {
	
	private final UserDao dao;
	private final Result result;
	private final Validator validator;
	private final UserInfo userInfo;

	public LoginController(UserDao dao, UserInfo userInfo, Result result, Validator validator) {
	    this.dao = dao;
		this.result = result;
	    this.validator = validator;
        this.userInfo = userInfo;
	}
	
	@Post("/login")
	@Public
	public void login(String login, String password) {
		
		final User currentUser = dao.find(login, password);

		validator.checking(new Validations() {{
		    that(currentUser, is(notNullValue()), "login", "invalid_login_or_password");
		}});
		validator.onErrorUsePageOf(this).login();

		userInfo.login(currentUser);

		result.redirectTo(ProjectsController.class).list();
	}
	
	@Get("/logout")
	public void logout() {
	    userInfo.logout();
	    result.redirectTo(this).login();
	}
	
	@Public
	@Get("/login")
	public void login() {
		//para simples redirecionamento
	}
}
