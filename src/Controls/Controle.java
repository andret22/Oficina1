package Controls;

import Interfaces.*;
import java.sql.*;

public class Controle {
    
    public static Connection Run(Connection conn){
        
        if(conn != null){
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin(conn).setVisible(true);
            }
        });
        }else{
            System.err.println("Houve um erro na conexao");
        }
        return conn;
    }
    
}
