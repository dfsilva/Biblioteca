/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.aedu.anhanghera.poo.biblioteca.telas.modelo;

import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class LivrosTableModel extends AbstractTableModel{

    private List<Livro> livros;
    private String[] colunas;

    public LivrosTableModel(List<Livro> livros) {
        this.livros = livros;
        this.colunas = new String[]{"ID",
        "Nome", "ISBN"};
    }
    
    @Override
    public int getRowCount() {
       return this.livros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, 
            int indiceColuna) {
        Livro livro = this.livros.get(indiceLinha);
        switch(indiceColuna){
            case 0: return livro.getId();
            case 1: return livro.getNome();
            case 2: return livro.getIsbn();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
    
    public Livro getValueAt(int indiceLinha){
        return this.livros.get(indiceLinha);
    }
    
}
