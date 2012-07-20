package br.com.ahrpius.blank.dao;

import java.util.List;

import br.com.ahrpius.blank.model.Server;

public interface ServerDao {

	void add(Server server);

	List<Server> listAll();

	Server find(Long id);
}
