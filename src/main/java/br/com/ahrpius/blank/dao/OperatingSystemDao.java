package br.com.ahrpius.blank.dao;

import java.util.List;

import br.com.ahrpius.blank.model.OperatingSystem;

public interface OperatingSystemDao {

	void add(OperatingSystem operatingSystem);

	List<OperatingSystem> listAll();

	OperatingSystem find(Long id);
}
