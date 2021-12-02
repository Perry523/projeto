package ufpb.dsc.projeto.edoe.com.servicos;

import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.dsc.projeto.edoe.com.dtos.PapelDto;
import ufpb.dsc.projeto.edoe.com.dtos.UsuarioLoginDto;
import ufpb.dsc.projeto.edoe.com.entidades.Usuario;
import ufpb.dsc.projeto.edoe.com.repositorios.UsuarioDAO;


@Service
public class ServicosUsuario {
	
	@Autowired
	private UsuarioDAO usuariosDAO;
	@Autowired
	private ServicoJWT servicoJwt;



	
	public Usuario adicionaUsuario(Usuario usuario) {
       
        usuariosDAO.save(usuario);
        return usuario;
    }

	public Usuario getUsuario(String email) {
		Optional<Usuario> optUsuario = usuariosDAO.findByEmail(email);
		if (optUsuario.isEmpty())
			throw new IllegalArgumentException();// usuario nao existe
		return optUsuario.get();
	}

	public Usuario removeUsuario(String email, String authHeader) throws ServletException {
		Usuario usuario = getUsuario(email);
		if (usuarioTemPermissao(authHeader, email)) {
			usuariosDAO.delete(usuario);
			return usuario;
		}
		throw new ServletException("Usuario nao tem permissao");
	}

	private boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
		String subject = servicoJwt.getSujeitoDoToken(authorizationHeader);
		Optional<Usuario> optUsuario = usuariosDAO.findByEmail(subject);
		return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
	}

	public boolean validaUsuarioSenha(UsuarioLoginDto usuario) {
		Optional<Usuario> optUsuario = usuariosDAO.findByEmail(usuario.getEmail());
		if (optUsuario.isPresent() && optUsuario.get().getSenha().equals(usuario.getSenha()))
			return true;
		return false;
	}
	
	public Usuario definirPapel(PapelDto papel, String header) {
		
		String emailAdmin = servicoJwt.getSujeitoDoToken(header);
		String email = papel.getEmail();
		
		Usuario usuario = usuariosDAO.getById(email);
		Usuario admin = usuariosDAO.getById(emailAdmin);
		
		if(admin.getClasse() == "ADMIN") {
			usuario.setPapel(papel.getPapel());
			usuariosDAO.save(usuario);
			
			return usuario;
		}
		throw new IllegalArgumentException();
		
		
		
	}
	
}
