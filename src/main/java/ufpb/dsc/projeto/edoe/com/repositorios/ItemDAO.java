package ufpb.dsc.projeto.edoe.com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufpb.dsc.projeto.edoe.com.entidades.Item;


@Repository
public interface ItemDAO extends JpaRepository<Item, Long>{

}
