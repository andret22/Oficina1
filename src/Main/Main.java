package Main;

import Controls.*;
import java.sql.*;

public class Main {
    
    
    private static Connection sqlConnect(){
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/oficinabd";
        String username = "umusuario";
        String password = "minhasenha";

        //Checa JDBC e cria conexão
        Connection connection = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // Connection successful
            System.out.println("Connected to the database!");
            
            PreparedStatement s = connection.prepareStatement("USE oficinabd");
            s.execute();
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    
    public static void main(String args[]) {
        Connection conn = sqlConnect();
        if(conn != null){    
            Controle.Run(conn);
        }
    }
}
