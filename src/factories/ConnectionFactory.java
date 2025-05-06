package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    /*
     * Método para conexão com banco de dados do PostgreSQL
     */
    public Connection obterConexao() {
        var host = "jdbc:postgresql://localhost:5432/projetoAula03";
        var user = "usuario_exemplo";
        var pass = "senha_segura";

        try {
            return DriverManager.getConnection(host, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
