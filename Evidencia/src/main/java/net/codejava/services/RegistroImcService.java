package net.codejava.services;

import net.codejava.entity.RegistroImc;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.repositories.RegistroImcRepository;

@Service
@Transactional
public class RegistroImcService {

	@Autowired
	private RegistroImcRepository repo;
	
	public List<RegistroImc> listAll() {
		return repo.findAll();
	}
	
	public void save(RegistroImc registro) {
		repo.save(registro);
	}
	
	public RegistroImc get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
