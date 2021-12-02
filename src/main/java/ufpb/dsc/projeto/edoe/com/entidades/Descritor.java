package ufpb.dsc.projeto.edoe.com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "descritor")
public class Descritor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descritor;
	
	
	

	public Long getId() {
		return id;
	}


	public String getDescritor() {
		return descritor;
	}

	public void setDescritor(String descritor) {
		this.descritor = descritor;
	}


	public Descritor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
