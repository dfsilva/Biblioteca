package br.aedu.anhanghera.poo.biblioteca.dominio;

import br.aedu.anhanghera.poo.biblioteca.excecao.LoginException;

public class Aluno extends Pessoa implements Autenticavel{

	public Aluno() {
		super();
	}

	public Aluno(String nome, String id, String senha) {
		super(nome, id, senha);
	}

	@Override
	public void autentica(String senha) throws LoginException {
		if(!this.senha.equals(senha)){
			throw new LoginException("Usuário ou senha inválidos");
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

}
