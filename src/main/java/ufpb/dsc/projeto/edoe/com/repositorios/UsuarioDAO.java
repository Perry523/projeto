package ufpb.dsc.projeto.edoe.com.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufpb.dsc.projeto.edoe.com.entidades.Usuario;


@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, String>{
	
	Optional<Usuario> findByEmail(String email);

}
