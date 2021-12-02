package ufpb.dsc.projeto.edoe.com.controladores;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.projeto.edoe.com.dtos.RespostaDeLogin;
import ufpb.dsc.projeto.edoe.com.dtos.UsuarioLoginDto;
import ufpb.dsc.projeto.edoe.com.servicos.ServicoJWT;

@RestController
@RequestMapping("/auth")
public class ControladorDeLogin {

	@Autowired
	private ServicoJWT servicoJwt;


	@PostMapping("/login")
	public ResponseEntity<RespostaDeLogin> autentica(@RequestBody UsuarioLoginDto usuario) throws ServletException {
		return new ResponseEntity<RespostaDeLogin>(servicoJwt.autentica(usuario), HttpStatus.OK);
	}

}