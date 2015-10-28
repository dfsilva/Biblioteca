package br.aedu.anhanghera.poo.biblioteca.dominio;

public abstract class Pessoa {
	
	protected String id;
	protected String nome;
	protected String senha;
	
	
	public Pessoa(){
		
	}
	
	public Pessoa(String nome, String id, String senha) {
		super();
		this.nome = nome;
		this.id = id;
		this.senha = senha;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
