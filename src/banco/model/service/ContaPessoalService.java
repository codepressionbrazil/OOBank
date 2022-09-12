package banco.model.service;

import banco.model.dao.ContaPessoalDAO;
import banco.model.entities.*;
import banco.view.Main;

import java.util.ArrayList;

public class ContaPessoalService {

    public static void sacar(int tipoConta, double valor) {
        ContaPessoal conta = buscarConta(Main.getUsuario(), tipoConta);
        conta.setSaldo(conta.getSaldo() - valor);
    }

    public static ContaPessoal buscarConta(Cliente cliente, int tipoConta) {
        ContaPessoalDAO contaPessoalDao = new ContaPessoalDAO();
        ArrayList<ContaPessoal> contas = new ArrayList<>(contaPessoalDao.buscarContas());

        for (ContaPessoal contaPessoal : contas) {
            if (contaPessoal.getCliente().equals(cliente)) {
                if (tipoConta == 1 && contaPessoal instanceof ContaCorrente) {
                    return contaPessoal;
                } else if (tipoConta == 2 && contaPessoal instanceof ContaPoupanca) {
                    return contaPessoal;
                } else if (tipoConta == 3 && contaPessoal instanceof ContaCredito) {
                    return contaPessoal;
                }
            }
        }
        return null;
    }


    public static ContaPessoal buscarContaNumero(int tipoConta, int numero) {
        ContaPessoalDAO contaPessoalDao = new ContaPessoalDAO();
        ArrayList<ContaPessoal> contas = new ArrayList<>(contaPessoalDao.buscarContas());
        for (ContaPessoal contaPessoal : contas) {
            if (contaPessoal.getNumero() == numero) {
                if (tipoConta == 1 && contaPessoal instanceof ContaCorrente) {
                    return contaPessoal;
                } else if (tipoConta == 2 && contaPessoal instanceof ContaPoupanca) {
                    return contaPessoal;
                } else if (tipoConta == 3 && contaPessoal instanceof ContaCredito) {
                    return contaPessoal;
                }
            }
        }
        return null;
    }

    public static void depositar(int tipoConta, int numero, double valor) {
        ContaPessoal conta = buscarContaNumero(tipoConta, numero);
        conta.setSaldo(conta.getSaldo() + valor);
    }
}
