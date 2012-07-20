package br.com.ahrpius.blank.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ahrpius.blank.dao.UserDao;
import br.com.ahrpius.blank.interceptor.UserInfo;
import br.com.ahrpius.blank.model.User;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class UserController {

    private final Validator validator;
    private final Result result;
	private final UserDao dao;
	private final UserInfo userInfo;

	public UserController(UserDao dao, Result result, Validator validator, UserInfo userInfo) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.userInfo = userInfo;
	}
	
	@Path("/users")
	@Get
	public void list() {
        List<User> users = new ArrayList<User>();
        List<User> usersFromDatabase = this.dao.listAll();
        for (User user : usersFromDatabase) {
            User newUser = new User();
            newUser.setCreation(user.getCreation());
            newUser.setOwner(user.getOwner());
            newUser.setLogin(user.getLogin());
            newUser.setName(user.getName());
            users.add(newUser);
        }

        result.include("users", users);
    }

	@Path("/users")
	@Post
	public void add(final User user) {
	    validator.checking(new Validations() {{
		    boolean loginDoesNotExist = !dao.containsUserWithLogin(user.getLogin());
		    that(loginDoesNotExist, "login", "login_already_exists");

		    that(user.getLogin().matches("[a-z0-9_]+"), "login", "invalid_login");
		}});

		validator.onErrorUsePageOf(this).list();
		user.setCreation(Calendar.getInstance());
		user.setOwner( userInfo.getUser() );
		this.dao.add(user);

		result.include("notice", "User " + user.getName() + " successfully added");
		result.redirectTo(this).list();
	}

	@Path("/users/{user.login}")
	@Get
	public void view(User user) {
	    result.include("user", dao.find(user.getLogin()));
	}

}
