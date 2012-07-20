package br.com.ahrpius.blank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InstalledSoftware {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne	
	private Software software;
	private String version;
	private String path;
	@ManyToOne
	private Server server;

}
