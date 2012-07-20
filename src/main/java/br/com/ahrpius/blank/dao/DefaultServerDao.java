package br.com.ahrpius.blank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ahrpius.blank.model.Server;
import br.com.caelum.vraptor.ioc.Component;

@Component
class DefaultServerDao implements ServerDao {

	private final Session session;

	DefaultServerDao(Session session) {
		this.session = session;
	}	
	
	public void add(Server server) {
		session.save(server);
	}

	@SuppressWarnings("unchecked")
	public List<Server> listAll() {
		return session.createCriteria(Server.class).list();
	}

	public Server find(Long id) {
		return (Server) session.createCriteria(Server.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
