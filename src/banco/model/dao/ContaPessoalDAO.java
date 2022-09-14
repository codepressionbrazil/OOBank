package banco.model.dao;

import banco.bdConnection.MySQLConnection;
import banco.model.entities.*;
import banco.model.service.ClienteService;
import com.mysql.cj.xdevapi.UpdateResult;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ContaPessoalDAO {

    private static LinkedHashSet<ContaPessoal> listaContaPessoal = new LinkedHashSet<>();
    static MySQLConnection conexao = new MySQLConnection();
    static Connection conn = conexao.conectaDB();
    static PreparedStatement pstm;
    static ResultSet rs;
    static UpdateResult ur;

//    static ClienteService clienteService = new ClienteService();
//
//    static {
//        listaContaPessoal.add(new ContaPessoal(1212, 1, "123",
//                clienteService.buscarCliente("Diego", "123"), 5000.0));
//        listaContaPessoal.add(new ContaPessoal(1313, 2, "123",
//                clienteService.buscarCliente("Gabriel", "321"), 10000.0));
//        listaContaPessoal.add(new ContaPessoal(1414, 3, "123",
//                clienteService.buscarCliente("Leonardo", "456"), 7000.00));
//    }

    public static Set buscarContas() {
        return Collections.unmodifiableSet(listaContaPessoal);
    }

    public static void cadastrarConta(ContaPessoal contaPessoal) throws SQLException {
        String sqlCommand = "insert into conta_pessoal (agencia, numeroConta, senha, saldo, cliente_cpf) values (?, ?, ?, ?, ?);";
        pstm = conn.prepareStatement(sqlCommand);
        pstm.setString(1, String.valueOf(contaPessoal.getAgencia()));
        pstm.setString(2, String.valueOf(contaPessoal.getNumero()));
        pstm.setString(3, String.valueOf(contaPessoal.getSenha()));
        pstm.setString(4, String.valueOf(contaPessoal.getSaldo()));
        pstm.setString(5, String.valueOf(contaPessoal.getClienteCPF()));
        pstm.execute();
        System.out.println("Conta cadastrada com sucesso!");
        listaContaPessoal.add(contaPessoal);
    }

    public static void depositar(ContaPessoal conta, double valor) throws SQLException {
        String sqlCommand = "update conta_pessoal set saldo = ? where numeroConta = ?";
        pstm = conn.prepareStatement(sqlCommand);
        pstm.setDouble(1, conta.getSaldo() + valor);
        pstm.setInt(2, conta.getNumero());
        pstm.execute();
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Saldo atualizado com sucesso!\n");
    }

    public static void sacar(ContaPessoal conta, double valor) throws SQLException {
        String sqlCommand = "update conta_pessoal set saldo = ? where numeroConta = ?";
        pstm = conn.prepareStatement(sqlCommand);
        pstm.setDouble(1, conta.getSaldo() - valor);
        pstm.setInt(2, conta.getNumero());
        pstm.execute();
        conta.setSaldo(conta.getSaldo() - valor);
        System.out.println("Saque concluído com sucesso!\n");
    }


    public static void atualizarRendas() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd");
        Date dataAtual = new Date();
        if(formatador.format(dataAtual).equals("5")){
            for(ContaPessoal contaPessoal : listaContaPessoal){
                contaPessoal.setSaldo(contaPessoal.getSaldo() + ClienteService.buscarPorCPF(contaPessoal.getClienteCPF()).getRenda());
            }
        }
    }

    public static void buscarDadosBD() throws SQLException {
        String query = "select * from conta_pessoal;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()){
            listaContaPessoal.add(
                    new ContaPessoal(
                            rs.getInt("agencia"),
                            rs.getInt("numeroConta"),
                            rs.getString("senha"),
                            rs.getString("cliente_cpf"),
                            rs.getDouble("saldo")
                    )
            );
        }
    }
}
