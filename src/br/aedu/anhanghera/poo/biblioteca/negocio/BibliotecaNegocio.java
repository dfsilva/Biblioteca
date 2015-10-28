package br.aedu.anhanghera.poo.biblioteca.negocio;


import br.aedu.anhanghera.poo.biblioteca.bd.LivroDAO;
import java.util.HashMap;
import java.util.Map;

import br.aedu.anhanghera.poo.biblioteca.dominio.Aluno;
import br.aedu.anhanghera.poo.biblioteca.dominio.Autenticavel;
import br.aedu.anhanghera.poo.biblioteca.dominio.Funcionario;
import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import br.aedu.anhanghera.poo.biblioteca.excecao.LoginException;
import br.aedu.anhanghera.poo.biblioteca.excecao.ReservaLivroException;

public class BibliotecaNegocio {
	
	private Map alunosSistema = new HashMap();
	private Map funcionariosSistema = new HashMap();
	
	private Map alunosAutenticados = new HashMap();
	
	private Map livrosReservados = new HashMap();
	
	
	
	public Aluno carregarAluno(String id){
		return (Aluno) alunosSistema.get(id);
	}
	
	public Funcionario carregarFuncionario(String id){
		return (Funcionario) funcionariosSistema.get(id);
	}
	
	public void popularAlunos(){
		System.out.println("Populando tabelas de usuários");
		for(int i = 0; i< 100; i++){
			Aluno a = new Aluno ("Aluno "+i, i+"A", "0000"+i);
			alunosSistema.put(a.getId(), a);
		}
		System.out.println(alunosSistema.size()+ " pessoas populadas no sistema");
	}
	
	public void popularFuncionarios(){
		for(int i = 0; i < 100; i++){
			Funcionario f = new Funcionario ("Funcionario "+i, i+"F", "0000"+i);
			funcionariosSistema.put(f.getId(), f);
		}
		System.out.println(funcionariosSistema.size()+ " pessoas populadas no sistema");
	}
	
	public void popularLivros(){
		for(int i = 0; i < 500; i++){
			Livro l = new Livro ("Livro "+1, "ISBN"+i);
			LivroDAO.inserir(l);
		}
	}
	
	
	public void autenticar(Autenticavel autenticavel, String senha) throws LoginException{
		System.out.println("Iniciando a autenticacao do usuário: "+autenticavel.getId());
		
		if(!alunosSistema.containsKey(autenticavel.getId()) && !funcionariosSistema.containsKey(autenticavel.getId())){
			throw new LoginException("Pessoa inesistente no sistema");
		}
		
		autenticavel.autentica(senha);
		alunosAutenticados.put(autenticavel.getId(), autenticavel);
		
		System.out.println("Usuário autenticado com sucesso "+autenticavel.getId());
	}

	public void reservar(Autenticavel autenticavel, String isbn) 
                throws ReservaLivroException{
	}
        
        public boolean atualizar(Livro livro){
            return LivroDAO.atualizar(livro);
        }
	
}
