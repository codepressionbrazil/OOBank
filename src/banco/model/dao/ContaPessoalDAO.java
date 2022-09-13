package banco.model.dao;

import banco.bdConnection.MySQLConnection;
import banco.model.entities.*;
import banco.model.service.ClienteService;
import com.mysql.cj.xdevapi.UpdateResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ContaPessoalDAO {

    private static Set<ContaPessoal> listaContaPessoal = new HashSet<>();
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
        pstm.setString(5, String.valueOf(contaPessoal.getCliente().getCpf()));
        pstm.execute();
        System.out.println("Conta cadastrada com sucesso!");
    }

    public static void depositar(ContaPessoal conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public static void sacar(ContaPessoal conta, double valor) {
        conta.setSaldo(conta.getSaldo() - valor);
    }


    public static void atualizarRendas() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd");
        Date dataAtual = new Date();
        if(formatador.format(dataAtual).equals("5")){
            for(ContaPessoal contaPessoal : listaContaPessoal){
                contaPessoal.setSaldo(contaPessoal.getSaldo() + contaPessoal.getCliente().getRenda());
            }
        }
    }
}
