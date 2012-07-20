package br.com.ahrpius.blank.interceptor;

import java.io.Serializable;

import br.com.ahrpius.blank.model.User;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UserInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

    public User getUser() {
        return user;
    }

    public void login(User user) {
        this.user = user;
    }

    public void logout() {
        this.user = null;
    }

}
