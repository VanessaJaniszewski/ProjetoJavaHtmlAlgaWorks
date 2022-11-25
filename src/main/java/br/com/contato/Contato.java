package br.com.contato;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {
	
	public Contato() {
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	@Column
	private String nome;
	@Column
	private String telefone;
	
	
	public boolean isNovo() {
		return id== null;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	

}
