package br.com.ahrpius.blank.interceptor;

import java.util.Arrays;

import br.com.ahrpius.blank.controller.LoginController;
import br.com.ahrpius.blank.dao.UserDao;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Intercepts
public class AuthorizationInterceptor implements Interceptor {

	private final UserInfo info;
	private final UserDao dao;
	private final Result result;

	public AuthorizationInterceptor(UserInfo info, UserDao dao, Result result) {
		this.info = info;
		this.dao = dao;
		this.result = result;
	}

    public boolean accepts(ResourceMethod method) {
        return !method.containsAnnotation(Public.class);
    }

    public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance)
            throws InterceptionException {
    	
    	if (info.getUser() == null) {
    		result.include("errors", Arrays.asList(new ValidationMessage("user is not logged in", "user")));
    		result.redirectTo(LoginController.class).login();
    	} else {
	    	dao.refresh(info.getUser());
	    	stack.next(method, resourceInstance);
    	}
    }

}
