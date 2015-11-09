/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.aedu.anhanghera.poo.biblioteca.bd;

import br.aedu.anhanghera.poo.biblioteca.dominio.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class LivroDAO {
    
    
    public static Livro inserir(Livro livro){
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = FabricaConexao.getConnection();
            stm = con
                    .prepareStatement("insert into livro(nome, isbn) values(?,?)", 
                    Statement.RETURN_GENERATED_KEYS);
            
            stm.setString(1, livro.getNome());
            stm.setString(2, livro.getIsbn());
            
            int retorno = stm.executeUpdate();
            
            if (retorno > 0) {
		rs = stm.getGeneratedKeys();
		if (rs.next()) {
		    livro.setId(rs.getLong(1));
		} else {
		    throw new SQLException("Criacao de livro falhouÏ");
		}
	    }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return livro;
    }
    
    
    public static boolean atualizar(Livro livro){
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection con = null;
        
        try{
            con = FabricaConexao.getConnection();
            stm = con.prepareStatement("update livro set nome = ? "
                    + ", isbn = ? where id = ?");
            stm.setString(1, livro.getNome());
            stm.setString(2, livro.getIsbn());
            stm.setLong(3, livro.getId());
            
            int qtdRegistrosAlterados = stm.executeUpdate();
            
            if(qtdRegistrosAlterados > 0){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
  
     public static List<Livro> listar(){
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection con = null;
        List<Livro> retorno = new ArrayList<>();
        
        try {
            con = FabricaConexao.getConnection();
            stm = con
                    .prepareStatement("select * from livro");
            
            rs = stm.executeQuery();
               
            while(rs.next()){
                Livro l = new Livro();
                l.setId(rs.getLong("id"));
                l.setNome(rs.getString("nome"));
                l.setIsbn(rs.getString("isbn"));
                
                retorno.add(l);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retorno;
    }
    
}
