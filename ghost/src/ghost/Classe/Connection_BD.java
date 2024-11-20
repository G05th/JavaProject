package ghost.Classe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection_BD {

    private static final String URL = "jdbc:mysql://localhost/Escola"; // URL do banco de dados
    private static final String USER = "ghost";                      // Usuário do banco de dados
    private static final String PASSWORD = "1234567890";             // Senha do banco de dados

    // Método estático para obter a conexão
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(Connection_BD.class.getName()).log(Level.SEVERE, "Erro na conexão com o banco de dados", ex);
        }
        return connection;
    }
}
