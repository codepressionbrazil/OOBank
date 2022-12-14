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
                if(valor <= conta.getSaldo()){
                    try {
                        ContaPessoalDAO.sacar(conta, valor);
                    } catch (SQLException err){
                        System.out.println(err.getMessage());
                    }
                } else {
                    System.out.println("Não é possível sacar mais do que o saldo atual: " + conta.getSaldo());
                }
            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }


    }


    public static ContaPessoal buscarContaNumero(int numero) {
        ArrayList<ContaPessoal> contas = new ArrayList<>(ContaPessoalDAO.buscarContas());
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
            try{
                ContaPessoalDAO.depositar(conta, valor);
            } catch (SQLException err){
                System.out.println(err.getMessage());
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void cadastrarConta(int agencia, int numero, String senha, String cliente_cpf) {
        try{
            ContaPessoalDAO.cadastrarConta(new ContaPessoal(agencia, numero, senha, cliente_cpf, 0.0));
        } catch (SQLException err){
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void mostrarConta(int numero, String senha) {
        ContaPessoal conta = buscarContaNumero(numero);
        if (conta != null) {
            if(conta.getClienteCPF().equals(Main.getUsuario().getCpf())){
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
            if(valorTransferencia <= conta.getSaldo()){
                try{
                    ContaPessoalDAO.depositar(contaBeneficiado, valorTransferencia);
                    ContaPessoalDAO.sacar(conta, valorTransferencia);

                    System.out.println("Transferência concluída com sucesso!");
                } catch (SQLException err){
                    System.out.println(err.getMessage());
                }
            } else {
                System.out.println("Não é possível transfeir mais do que o saldo atual: " + conta.getSaldo());
            }
        } else {
            System.out.println("Conta do beneficado não encontrada!");
        }

    }

    public static void atualizarRendas() {
        try{
            ContaPessoalDAO.atualizarRendas();
        } catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public static void buscarDadosBD() {
        try{
            ContaPessoalDAO.buscarDadosBD();
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
