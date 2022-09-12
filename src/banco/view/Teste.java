package banco.view;

import banco.bdConnection.MySQLConnection;
import banco.model.entities.Cliente;
import com.mysql.cj.xdevapi.UpdateResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {
    static MySQLConnection conexao = new MySQLConnection();
    static Connection conn = conexao.conectaDB();
    static PreparedStatement pstm;
    static ResultSet rs;
    static UpdateResult ur;

    public static void main(String[] args) {
        try{
            adicionarCliente(new Cliente("Leonardo", "José Narloch, 2214", "11209407965", "Programador", 7000.0, "123"));
            buscarClientes();
        } catch (SQLException err){
            System.out.println("SQL Stmt Error: " + err.getSQLState());
            System.out.println("Error: " + err.getMessage());
        }
    }

    public static void adicionarCliente(Cliente cliente) throws SQLException, SQLException {
        String sqlCommand = "insert into clientes (nome,  senha, endereco, cpf, profissao, renda) values (?, ?, ?, ?, ?, ?)";
        pstm = conn.prepareStatement(sqlCommand);
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getSenha());
        pstm.setString(3, cliente.getEndereco());
        pstm.setString(4, cliente.getCpf());
        pstm.setString(5, cliente.getProfissao());
        pstm.setString(6, String.valueOf(cliente.getRenda()));
        pstm.execute();
        System.out.println("A intenção é cadastrar!");
    }

    public static void buscarClientes() throws SQLException {
        String sqlCommand = "select * from clientes";
        pstm = conn.prepareStatement(sqlCommand);
        rs = pstm.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("nome"));
        }
    }
}
