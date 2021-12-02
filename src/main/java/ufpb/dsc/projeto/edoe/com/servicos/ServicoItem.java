package ufpb.dsc.projeto.edoe.com.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.dsc.projeto.edoe.com.dtos.TextoDto;
import ufpb.dsc.projeto.edoe.com.entidades.Descritor;
import ufpb.dsc.projeto.edoe.com.entidades.Usuario;
import ufpb.dsc.projeto.edoe.com.repositorios.DescritorDAO;
import ufpb.dsc.projeto.edoe.com.repositorios.ItemDAO;
import ufpb.dsc.projeto.edoe.com.repositorios.UsuarioDAO;
import ufpb.dsc.projeto.edoe.com.entidades.Item;

@Service
public class ServicoItem {
	
	@Autowired
	private DescritorDAO descritorDAO;	
	@Autowired
	private ServicoJWT servicoJwt;
	@Autowired
	private UsuarioDAO usuariosDAO;
	@Autowired
	private ItemDAO itemDAO;
	
	
	
	
	
	
	
	public List<Descritor> listarDescritores(String header){
		
		String email = servicoJwt.getSujeitoDoToken(header);		
		Optional<Usuario> optUsuario = usuariosDAO.findByEmail(email);
		
		
		if (optUsuario.isEmpty()) {
			throw new IllegalArgumentException();// usuario nao existe
		}
		
		List<Descritor> descritores = descritorDAO.findAll();
		
		return descritores;
		
	}
	
	public Descritor adicionaDescritor(TextoDto texto, String header) {
		
		String email = servicoJwt.getSujeitoDoToken(header);		
		Optional<Usuario> optUsuario = usuariosDAO.findByEmail(email);
		
		
		if (optUsuario.isEmpty()) {
			throw new IllegalArgumentException();// usuario nao existe
		}
		
		Descritor descritor = new Descritor();
		
		descritor.setDescritor(texto.getTexto());
		
		descritorDAO.save(descritor);
		
		return descritor;
		
		
	}
	
	public Item adicionarItem(String header) {
		
		String email = servicoJwt.getSujeitoDoToken(header);		
		Optional<Usuario> optUsuario = usuariosDAO.findByEmail(email);
		
		
		if (optUsuario.isEmpty()) {
			throw new IllegalArgumentException();// usuario nao existe
		}
		
		Item item = new Item();
		
		return item;
		
		
		
	}
	
	public List<Item> retorno(){
		
		
		return itemDAO.findAll();	}

}
