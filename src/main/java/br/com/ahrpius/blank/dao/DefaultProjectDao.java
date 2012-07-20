package br.com.ahrpius.blank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ahrpius.blank.model.Project;
import br.com.caelum.vraptor.ioc.Component;

@Component
class DefaultProjectDao implements ProjectDao {
	
	private final Session session;

	DefaultProjectDao(Session session) {
		this.session = session;
	}

	public void add(Project project) {
		session.save(project);
	}

	@SuppressWarnings("unchecked")
	public List<Project> listAll() {
		return session.createCriteria(Project.class).list();
	}

	public Project find(Long id) {
		return (Project) session.createCriteria(Project.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
}
