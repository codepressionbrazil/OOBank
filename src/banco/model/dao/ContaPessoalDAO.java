package banco.model.dao;

import banco.model.entities.*;
import banco.model.service.ClienteService;

import java.text.SimpleDateFormat;
import java.util.*;

public class ContaPessoalDAO {

    private static Set<ContaPessoal> listaContaPessoal = new HashSet<>();
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

    public static void cadastrarConta(ContaPessoal contaPessoal) {
        listaContaPessoal.add(contaPessoal);
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
