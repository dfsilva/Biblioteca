/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.aedu.anhanghera.poo.biblioteca.gui.model;

import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 98379720172
 */
public class LivroTableModel extends AbstractTableModel {

    private List<Livro> livros;
    private String[] colunas;

    public LivroTableModel(List<Livro> livros) {
        super();
        this.livros = livros;
        colunas = new String[]{"ID", "NOME", "ISBN", "Excluir"};
    }

    @Override
    public int getRowCount() {
        return livros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro l = livros.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return l.getId();
            case 1:
                return l.getNome();
            case 2:
                return l.getIsbn();
            case 3: 
                return "Excluir livro";
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Livro getValueAt(int i) {
        return this.livros.get(i);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column > 2) {
            return true;
        }
        return false;
    }
}
