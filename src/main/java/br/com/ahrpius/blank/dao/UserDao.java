package br.com.ahrpius.blank.dao;

import java.util.List;

import br.com.ahrpius.blank.model.User;

public interface UserDao {

	User find(String login, String password);

	User find(String login);

	void add(User user);

	void refresh(User user);

	void update(User user);

	List<User> listAll();

	boolean containsUserWithLogin(String login);

}