package br.com.ahrpius.blank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SystemUser {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Server server;
	private String user;
	private String password;
	private String description;

}
