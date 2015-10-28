package br.aedu.anhanghera.poo.biblioteca.dominio;

public class Livro {

    private long id;
    private String nome;
    private String isbn;

    public Livro() {
    }

    public Livro(String nome, String isbn) {
        super();
        this.nome = nome;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
