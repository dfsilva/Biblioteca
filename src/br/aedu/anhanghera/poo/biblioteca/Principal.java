package br.aedu.anhanghera.poo.biblioteca;

import br.aedu.anhanghera.poo.biblioteca.bd.FabricaConexao;
import br.aedu.anhanghera.poo.biblioteca.dominio.Aluno;
import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import br.aedu.anhanghera.poo.biblioteca.excecao.LoginException;
import br.aedu.anhanghera.poo.biblioteca.excecao.ReservaLivroException;
import br.aedu.anhanghera.poo.biblioteca.negocio.BibliotecaNegocio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    private static BibliotecaNegocio bibliotecaNegocio = new BibliotecaNegocio();

    public static void main(String[] args) {

      bibliotecaNegocio.popularLivros();
       
       Livro l = new Livro();
       l.setId(1);
       l.setNome("Registro alterado");
       l.setIsbn("isbn alterado");
       
       if(bibliotecaNegocio.atualizar(l)){
           System.out.println("Livro atualizado");
       }else{
           System.out.println("Livro nao atualizado");
       }
    }

}
