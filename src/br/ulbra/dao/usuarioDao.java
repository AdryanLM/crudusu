/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;


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
public class usuarioDao {

    public void create(usuario u) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbusuario(nomeusu,"
                    + "emailusu,senhausu)VALUES(?,?,?)");
            stmt.setString(1, u.getNomeUsu());
            stmt.setString(2, u.getEmailUsu());
            stmt.setString(3, u.getSenhaUsu());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public List<usuario> read() {
      Connection con = connectionFactory.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      List<usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from tbusuario");
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setIdUsu(rs.getInt("idusu"));  usuario.setNomeUsu(rs.getString("nomeusu"));
                usuario.setEmailUsu(rs.getString("emailusu"));usuario.setSenhaUsu(rs.getString("senhausu"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;

    }

    public List<usuario> readForDesc(String desc) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE nomeusu LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setIdUsu(rs.getInt("idusu"));   usuario.setNomeUsu(rs.getString("nomeusu"));
                usuario.setEmailUsu(rs.getString("emailusu")); usuario.setSenhaUsu(rs.getString("senhausu"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }

    public void update(usuario u) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbusuario SET nomeusu = ? ,emailusu = ?,senhausu = ? "
                    + "WHERE idusu = ?");
            stmt.setString(1, u.getNomeUsu());
            stmt.setString(2, u.getEmailUsu());
            stmt.setString(3, u.getSenhaUsu());
            stmt.setInt(4, u.getIdUsu());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(usuario u) {

        Connection con = connectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbusuario WHERE idusu = ?");
            stmt.setInt(1, u.getIdUsu());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

    
    
    public boolean checkLogin(String login, String senha) {

        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE emailusu = ? and senhausu = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

}