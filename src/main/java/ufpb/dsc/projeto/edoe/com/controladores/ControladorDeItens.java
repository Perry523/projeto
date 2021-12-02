package ufpb.dsc.projeto.edoe.com.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.projeto.edoe.com.servicos.ServicoItem;
import ufpb.dsc.projeto.edoe.com.dtos.TextoDto;
import ufpb.dsc.projeto.edoe.com.entidades.Descritor;
import ufpb.dsc.projeto.edoe.com.entidades.Item;



@RestController
public class ControladorDeItens {
	
	@Autowired
	private ServicoItem servicoItem;
	
	
	
	
	
	
	@GetMapping("edoe.com/descritores")
	public ResponseEntity<List<Descritor>> listarDescritores(@RequestHeader("Authorization") String header) {
		return new ResponseEntity<List<Descritor>>(this.servicoItem.listarDescritores(header), HttpStatus.OK);
	}
	
	@PostMapping("edoe.com/descritores")
	public ResponseEntity<Descritor> adicionarDescritor(@RequestBody TextoDto texto, @RequestHeader("Authorization") String header) {
		return new ResponseEntity<Descritor>(this.servicoItem.adicionaDescritor(texto, header), HttpStatus.CREATED);
	}
	
	@PostMapping("edoe.com/itens")
	public ResponseEntity<Item> adicionarItem(@RequestHeader("Authorization") String header) {
		return new ResponseEntity<Item>(this.servicoItem.adicionarItem(header), HttpStatus.CREATED);
	}
	
	@GetMapping("edoe.com/doacoes/itens")
	public ResponseEntity<List<Item>> listarItensDoacao() {
		return new ResponseEntity<>(this.servicoItem.retorno() ,HttpStatus.OK);
	}
	
	@PostMapping("edoe.com/doacoes/itens")
	public ResponseEntity<Item> adicionarItemDoacao(@RequestHeader("Authorization") String header) {
		return new ResponseEntity<Item>(this.servicoItem.adicionarItem(header), HttpStatus.CREATED);
	}
	
	@GetMapping("edoe.com/doacoes/n_itens")
	public ResponseEntity<List<Item>> listarItensNecessarios() {
		return new ResponseEntity<>(this.servicoItem.retorno() ,HttpStatus.OK);
	}
	
	@GetMapping("edoe.com/doacoes/itens/match")
	public ResponseEntity<List<Item>> listarItensDoacaoMatches() {
		return new ResponseEntity<>(this.servicoItem.retorno() ,HttpStatus.OK);
	}
	
	@PostMapping("edoe.com/doacoes")
	public ResponseEntity<List<Item>> realizarDoacao() {
		return new ResponseEntity<>(this.servicoItem.retorno() ,HttpStatus.CREATED);
	}
	
	@GetMapping("edoe.com/doacoes")
	public ResponseEntity<List<Item>> historicoDoacao() {
		return new ResponseEntity<>(this.servicoItem.retorno() ,HttpStatus.OK);
	}
	
	

}
