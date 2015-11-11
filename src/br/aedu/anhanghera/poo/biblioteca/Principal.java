package br.aedu.anhanghera.poo.biblioteca;

import br.aedu.anhanghera.poo.biblioteca.bd.FabricaConexao;
import br.aedu.anhanghera.poo.biblioteca.dominio.Aluno;
import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import br.aedu.anhanghera.poo.biblioteca.excecao.LoginException;
import br.aedu.anhanghera.poo.biblioteca.excecao.ReservaLivroException;
import br.aedu.anhanghera.poo.biblioteca.negocio.BibliotecaNegocio;
import br.aedu.anhanghera.poo.biblioteca.telas.TelaPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    private static BibliotecaNegocio bibliotecaNegocio = new BibliotecaNegocio();

    public static void main(String[] args) {

      bibliotecaNegocio.popularLivros();
      
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
      
    }

}
