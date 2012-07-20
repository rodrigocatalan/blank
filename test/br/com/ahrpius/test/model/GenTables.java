package br.com.ahrpius.test.model;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.ahrpius.blank.model.InstalledSoftware;
import br.com.ahrpius.blank.model.OperatingSystem;
import br.com.ahrpius.blank.model.Project;
import br.com.ahrpius.blank.model.Server;
import br.com.ahrpius.blank.model.Software;
import br.com.ahrpius.blank.model.SystemUser;
import br.com.ahrpius.blank.model.User;

public class GenTables {

	public static void main(String[] args){
		Configuration configuration = new Configuration();

		configuration
		.addAnnotatedClass(Software.class)
		.addAnnotatedClass(Server.class)
		.addAnnotatedClass(SystemUser.class)
		.addAnnotatedClass(InstalledSoftware.class)
		.addAnnotatedClass(OperatingSystem.class)
		.addAnnotatedClass(Project.class)
		.addAnnotatedClass(User.class)
		.setProperty(Environment.USER, "root")
		.setProperty(Environment.PASS, "password")
		.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/blank")
		.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect")
		.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");

		SchemaExport schema = new SchemaExport(configuration);
		schema.setOutputFile("schema.sql");

		schema.create(true, true);		
	}

}
