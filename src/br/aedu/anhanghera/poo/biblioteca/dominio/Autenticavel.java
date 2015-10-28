package br.aedu.anhanghera.poo.biblioteca.dominio;

import br.aedu.anhanghera.poo.biblioteca.excecao.LoginException;

public interface Autenticavel {
	
	void autentica(String senha) throws LoginException;
	
	String getId();

}
