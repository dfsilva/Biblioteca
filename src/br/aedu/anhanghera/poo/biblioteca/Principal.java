package br.aedu.anhanghera.poo.biblioteca;

import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import br.aedu.anhanghera.poo.biblioteca.gui.JanelaPrincipal;
import br.aedu.anhanghera.poo.biblioteca.negocio.BibliotecaNegocio;
import java.util.List;
import javax.swing.JFrame;

public class Principal {

    private static BibliotecaNegocio bibliotecaNegocio = new BibliotecaNegocio();
    private static JanelaPrincipal janelaPrincipal;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                janelaPrincipal = new JanelaPrincipal();
                janelaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                janelaPrincipal.setVisible(true);
            }
        });
    }

}
