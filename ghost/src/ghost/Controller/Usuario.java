/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ghost.Controller;
import ghost.Classe.Connection_BD;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ghost.model.bean.UsuarioModel;


/**
 *
 * @author ghost
 */

public class Usuario {
    
    // Método para criar um novo usuário
    public boolean createUsuario(UsuarioModel usuario) {
        String query = "INSERT INTO usuario (nome, email, endereco, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getEndereco());
            stmt.setString(4, usuario.getSenha());

            stmt.executeUpdate();
            return true;
             // Operação bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
             // Operação falhou
             return false;
        }
        
    }
    
    // Método para ler informações de um ou mais usuários
    public List<UsuarioModel> readUsuarios() {
        
        List<UsuarioModel> usuario = new ArrayList<>();

    String query = "SELECT * FROM usuario";

    try (Connection conn = Connection_BD.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
            
            
            DefaultTableModel model = new DefaultTableModel();
            
            while (rs.next()) {
                UsuarioModel usuarios = new UsuarioModel();
                
                usuarios.setId_usuario(rs.getInt("id_usuario"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setEmail(rs.getString("email"));
                usuarios.setEndereco(rs.getString("endereco"));
                usuarios.setSenha(rs.getString("senha"));
                usuario.add(usuarios);
        }
            
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return usuario;

}

    // Método para atualizar um usuário existente
    public boolean updateUsuario(UsuarioModel usuario) {
        String query = "UPDATE usuario SET nome = ?, email = ?, endereco = ?, senha = ? WHERE id_usuario = ?";
        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getEndereco());
            stmt.setString(4, usuario.getSenha());
            stmt.setInt(5, usuario.getId_usuario());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para deletar um usuário
    public boolean deleteUsuario(UsuarioModel usuario) {
        String query = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, usuario.getId_usuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
}
}