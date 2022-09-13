package banco.controller;

import banco.model.entities.Cliente;
import banco.model.entities.ContaPessoal;
import banco.model.service.ContaPessoalService;

public class ContaPessoalController {


    public static void sacar(int numero, String senha, double valor) {
        ContaPessoalService.sacar(numero, senha, valor);
    }


    public static void depositar(int numero, double valor) {
        ContaPessoalService.depositar(numero, valor);
    }

    public static void cadastrarConta(int agencia, int numero, String senha, Cliente clienteLogado) {
        ContaPessoalService.cadastrarConta(agencia, numero, senha, clienteLogado);
    }

    public static void mostrarConta(int numero, String senha) {
        ContaPessoalService.mostrarConta(numero, senha);
    }

    public static ContaPessoal verificaConta(int numero, String senha) {
        return ContaPessoalService.verificaConta(numero, senha);
    }

    public static void tranferir(ContaPessoal conta, int numeroBeneficiado, double valorTransferencia) {
        ContaPessoalService.trasferir(conta, numeroBeneficiado, valorTransferencia);
    }

    public static void atualizarRendas() {
        ContaPessoalService.atualizarRendas();
    }
}
