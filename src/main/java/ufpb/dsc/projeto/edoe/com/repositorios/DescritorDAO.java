package ufpb.dsc.projeto.edoe.com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufpb.dsc.projeto.edoe.com.entidades.Descritor;

@Repository
public interface DescritorDAO extends JpaRepository<Descritor, Long>{

}
