package br.com.ahrpius.blank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ahrpius.blank.model.OperatingSystem;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class DefaultOperatingSystemDao implements OperatingSystemDao {

	private final Session session;

	DefaultOperatingSystemDao(Session session) {
		this.session = session;
	}

	public void add(OperatingSystem operatingSystem) {
		session.save(operatingSystem);
	}

	@SuppressWarnings("unchecked")
	public List<OperatingSystem> listAll() {
		return session.createCriteria(OperatingSystem.class).list();
	}

	public OperatingSystem find(Long id) {
		return (OperatingSystem) session.createCriteria(OperatingSystem.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
