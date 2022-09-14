package banco.model.dao;

import banco.bdConnection.MySQLConnection;
import banco.model.entities.Cliente;
import com.mysql.cj.xdevapi.UpdateResult;

import java.sql.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClienteDAO {
    private static final Set<Cliente> listaClientes = new HashSet<>();
    static MySQLConnection conexao = new MySQLConnection();
    static Connection conn = conexao.conectaDB();
    static PreparedStatement pstm;
    static ResultSet rs;
    static UpdateResult ur;

    static {
//        listaClientes.add(new Cliente("Diego", "Rua tal", "123", "DEV BACKEND", 7000.00, "123"));
//        listaClientes.add(new Cliente("Gabriel", "Rua tal", "321", "DEV FRONTEND", 5000.00, "321"));
//        listaClientes.add(new Cliente("Leonardo", "Rua tal", "456", "DEV BACKEND", 10000.00, "456"));
    }


    public static Set<Cliente> buscarClientes() throws SQLException {
        return Collections.unmodifiableSet(listaClientes);
    }

    public static void buscarDadosBD() throws SQLException {
        String sqlCommand = "select * from clientes";
        pstm = conn.prepareStatement(sqlCommand);
        rs = pstm.executeQuery();
        while(rs.next()){
            listaClientes.add(new Cliente(rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("cpf"),
                    rs.getString("profissao"),
                    rs.getDouble("renda"),
                    rs.getString("senha")
            ));
        }
    }

    public boolean cadastrar(Cliente cliente) throws SQLException {
        String sqlCommand = "insert into clientes (nome,  senha, endereco, cpf, profissao, renda) values (?, ?, ?, ?, ?, ?)";
        pstm = conn.prepareStatement(sqlCommand);
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getSenha());
        pstm.setString(3, cliente.getEndereco());
        pstm.setString(4, cliente.getCpf());
        pstm.setString(5, cliente.getProfissao());
        pstm.setString(6, String.valueOf(cliente.getRenda()));
        pstm.execute();
        conn.close();
        listaClientes.add(cliente);
        return true;
    }

}
