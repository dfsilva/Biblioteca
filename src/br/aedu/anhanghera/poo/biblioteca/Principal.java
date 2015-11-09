package br.aedu.anhanghera.poo.biblioteca;

import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import br.aedu.anhanghera.poo.biblioteca.negocio.BibliotecaNegocio;
import java.util.List;

public class Principal {

    private static BibliotecaNegocio bibliotecaNegocio = new BibliotecaNegocio();

    public static void main(String[] args) {

        bibliotecaNegocio.popularLivros();

        List<Livro> livros = bibliotecaNegocio.listarLivros();

        System.out.println("Existe " + livros.size()
                + " cadastrados no sistema");

        for (int i = 0; i < livros.size(); i++) {
            System.out.println(livros.get(i).getIsbn());
        }

    }

}
