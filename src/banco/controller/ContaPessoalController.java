package banco.controller;

import banco.model.entities.Cliente;
import banco.model.entities.ContaPessoal;
import banco.model.service.ContaPessoalService;

public class ContaPessoalController {

    public static void sacar(int tipoConta, double valor) {
        ContaPessoalService.sacar(tipoConta, valor);
    }

    public static ContaPessoal buscarConta(Cliente c, int tipoConta) {
        ContaPessoalService contaPessoalService = new ContaPessoalService();
        return contaPessoalService.buscarConta(c, tipoConta);
    }

    public static void depositar(int tipoConta, int numero) {
        ContaPessoalService contaPessoalService = new ContaPessoalService();
        return contaPessoalService.depositar(tipoConta, numero);
    }
}
