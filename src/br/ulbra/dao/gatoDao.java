/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;


import br.ulbra.model.gato;
import br.ulbra.model.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ponei
 */
public class gatoDao {

    public void create(gato g) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbgato(nomegato,generogato,racagato,nascimentogato,tamanhogato,vacinadogato,corgato,pesogato,microchipgato,descricaogato)VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, g.getNomeGato());
            stmt.setString(2, g.getGeneroGato());
            stmt.setString(3, g.getRacaGato());
            stmt.setString(4, g.getNascimentoGato());
            stmt.setDouble(5, g.getTamanhoGato());
            int vacinado = 0;
            if (g.isVacinadoGato()){
                vacinado = 1;
            }
            stmt.setInt(6, vacinado);
            stmt.setString(7, g.getCorGato());
            stmt.setDouble(8, g.getPesoGato());
            int microchip = 0;
            if (g.isMicrochipGato()){
                microchip = 1;
            }
            stmt.setInt(9, microchip);
            stmt.setString(10, g.getDescricaoGato());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public List<gato> read() {
      Connection con = connectionFactory.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      List<gato> gatos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from tbgato");
            rs = stmt.executeQuery();
            while (rs.next()) {
                gato g = new gato();
                
                g.setIdGato(rs.getInt("idgato"));  
                g.setNomeGato(rs.getString("nomegato"));
                g.setGeneroGato(rs.getString("generogato"));
                g.setRacaGato(rs.getString("racagato"));
                g.setNascimentoGato(rs.getString("nascimentogato"));
                g.setTamanhoGato(rs.getDouble("tamanhogato"));
                g.setVacinadoGato(rs.getBoolean("vacinadogato"));
                g.setCorGato(rs.getString("corgato"));
                g.setPesoGato(rs.getDouble("pesogato"));
                g.setMicrochipGato(rs.getBoolean("microchipgato"));
                g.setDescricaoGato(rs.getString("descricaogato"));
                
                gatos.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return gatos;

    }

    public List<gato> readForDesc(String desc) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<gato> gatos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbgato WHERE nomegato LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                gato g = new gato();
                g.setIdGato(rs.getInt("idgato"));  
                g.setNomeGato(rs.getString("nomegato"));
                g.setGeneroGato(rs.getString("generogato"));
                g.setRacaGato(rs.getString("racagato"));
                g.setNascimentoGato(rs.getString("nascimentogato"));
                g.setTamanhoGato(rs.getDouble("tamanhogato"));
                g.setVacinadoGato(rs.getBoolean("vacinadogato"));
                g.setCorGato(rs.getString("corgato"));
                g.setPesoGato(rs.getDouble("pesogato"));
                g.setMicrochipGato(rs.getBoolean("microchipgato"));
                g.setDescricaoGato(rs.getString("descricaogato"));
                gatos.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return gatos;
    }

    public void update(gato g) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbgato SET nomegato = ?, generogato = ?, racagato = ?, nascimentogato = ?, tamanhogato = ?, vacinadogato = ?, corgato = ?, pesogato = ?, microchipgato = ?, descricaogato = ? WHERE idgato = ?");
            stmt.setString(1, g.getNomeGato());
            stmt.setString(2, g.getGeneroGato());
            stmt.setString(3, g.getRacaGato());
            stmt.setString(4, g.getNascimentoGato());
            stmt.setDouble(5, g.getTamanhoGato());
            int vacinado = 0;
            if (g.isVacinadoGato()){
                vacinado = 1;
            }
            stmt.setInt(6, vacinado);
            stmt.setString(7, g.getCorGato());
            stmt.setDouble(8, g.getPesoGato());
            int microchip = 0;
            if (g.isMicrochipGato()){
                microchip = 1;
            }
            stmt.setInt(9, microchip);
            stmt.setString(10, g.getDescricaoGato());
            stmt.setInt(11, g.getIdGato());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(gato g) {

        Connection con = connectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbgato WHERE idgato = ?");
            stmt.setInt(1, g.getIdGato());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }
}