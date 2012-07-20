package br.com.ahrpius.blank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OperatingSystem {
	
	@Id
	@GeneratedValue
	private Long id;
	private String description;

}
