package br.aedu.anhanghera.poo.biblioteca;

import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import br.aedu.anhanghera.poo.biblioteca.gui.JanelaPrincipal;
import br.aedu.anhanghera.poo.biblioteca.negocio.BibliotecaNegocio;
import java.util.List;

public class Principal {

    private static BibliotecaNegocio bibliotecaNegocio = new BibliotecaNegocio();

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });

    }

}
