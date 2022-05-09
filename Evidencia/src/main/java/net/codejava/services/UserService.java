/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.codejava.entity.RegistroImc;
import net.codejava.entity.Usuario;
import net.codejava.repositories.RegistroImcRepository;
import net.codejava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose.jimenez07
 */
@Service
@Transactional
public class UserService {

        @Autowired
	private UserRepository repo;
	
	public List<Usuario> listAll() {
		return repo.findAll();
	}
	
	public void save(Usuario usuario) {
		repo.save(usuario);
	}
	
	public Usuario get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
