package banco.model.service;

import banco.model.dao.ContaPessoalDAO;
import banco.model.entities.*;
import banco.view.Main;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContaPessoalService {

    public static void sacar(int numero, String senha, double valor) {
        ContaPessoal conta = buscarContaNumero(numero);
        if (conta != null) {
            if (conta.getSenha().equals(senha)) {
                ContaPessoalDAO.sacar(conta, valor);
            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }


    }


    public static ContaPessoal buscarContaNumero(int numero) {
        ContaPessoalDAO contaPessoalDao = new ContaPessoalDAO();
        ArrayList<ContaPessoal> contas = new ArrayList<>(contaPessoalDao.buscarContas());
        for (ContaPessoal contaPessoal : contas) {
            if (contaPessoal.getNumero() == numero) {
                return contaPessoal;
            }
        }
        return null;
    }

    public static void depositar(int numero, double valor) {
        ContaPessoal conta = buscarContaNumero(numero);
        if (conta != null) {
            ContaPessoalDAO.depositar(conta, valor);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void cadastrarConta(int agencia, int numero, String senha, Cliente clienteLogado) {
        try{
            ContaPessoalDAO.cadastrarConta(new ContaPessoal(agencia, numero, senha, clienteLogado, 0.0));
        } catch (SQLException err){
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void mostrarConta(int numero, String senha) {
        ContaPessoal conta = buscarContaNumero(numero);
        if (conta != null) {
            if(conta.getCliente().equals(Main.getUsuario())){
                if (conta.getSenha().equals(senha)) {
                    System.out.println(conta);
                } else {
                    System.out.println("Senha incorreta!");
                }
            } else {
                System.out.println("Erro: Conta não encontrada!");
            }
        } else {
            System.out.println("Erro: Conta não encontrada!");
        }
    }

    public static ContaPessoal verificaConta(int numero, String senha) {
        ContaPessoal conta = buscarContaNumero(numero);
        if (conta != null) {
            if (conta.getSenha().equals(senha)) {
                return conta;
            } else {
                System.out.println("Senha incorreta!");
                return null;
            }
        }
        System.out.println("Conta não encontrada!");
        return null;
    }

    public static void trasferir(ContaPessoal conta, int numeroBeneficiado, double valorTransferencia) {
        ContaPessoal contaBeneficiado = buscarContaNumero(numeroBeneficiado);
        if(contaBeneficiado != null){
            ContaPessoalDAO.depositar(contaBeneficiado, valorTransferencia);
            ContaPessoalDAO.sacar(conta, valorTransferencia);
        } else {
            System.out.println("Conta do beneficado não encontrada!");
        }

    }

    public static void atualizarRendas() {
        ContaPessoalDAO.atualizarRendas();
    }
}
