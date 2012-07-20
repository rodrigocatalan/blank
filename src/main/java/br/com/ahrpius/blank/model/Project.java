package br.com.ahrpius.blank.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private Calendar creation;
	@ManyToOne
	private User owner;
	@Cascade(CascadeType.SAVE_UPDATE)
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Server> servers = new ArrayList<Server>();
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//metodo privado pois não existe necessidade de setar o id
	//o metodo só existe para que o vraptor injete o valor
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public List<Server> getServers() {
		return servers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getCreation() {
		return creation;
	}
	public void setCreation(Calendar creation) {
		this.creation = creation;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	//
	public void addServer(Server server){
		this.servers.add(server);
	}
	
}
