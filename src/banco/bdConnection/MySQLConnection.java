package banco.bdConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public Connection conectaDB(){
        Connection conn = null;
        try{
            String url = "jdbc:mysql://localhost:3306/bancoKaren";
            String username = "root";
            String password = "root";


            conn = DriverManager.getConnection(url, username, password);

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

        return conn;
    }
}
