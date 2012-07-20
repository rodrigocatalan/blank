package br.com.ahrpius.blank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.ahrpius.blank.model.User;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class DefaultUserDao implements UserDao {

	private final Session session;

	public DefaultUserDao(Session session) {
		this.session = session;
	}

	public User find(String login, String password) {
		String hql = "from User u where u.login = :login and u.password = :password";

		Query query = session.createQuery(hql)
			.setParameter("login", login)
			.setParameter("password", password);

		return (User) query.uniqueResult();
	}

	public User find(String login) {
		String hql = "from User u where u.login = :login";

		Query query = session.createQuery(hql).setParameter("login", login);

		return (User) query.uniqueResult();
	}

	public void add(User user) {
		session.save(user);
	}

	public void refresh(User user) {
		session.refresh(user);
	}

	public void update(User user) {
		session.update(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listAll() {
		return session.createCriteria(User.class).list();
	}

	public boolean containsUserWithLogin(String login) {
		String hql = "from User user where user.login = :login";
		Query query = session.createQuery(hql).setParameter("login", login);

		return !query.list().isEmpty();
	}

}
