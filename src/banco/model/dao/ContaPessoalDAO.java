package banco.model.dao;

import banco.model.entities.Cliente;
import banco.model.entities.ContaPessoal;
import banco.model.service.ClienteService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ContaPessoalDAO {

    private static Set<ContaPessoal> listaContaPessoal = new HashSet<>();
    static ClienteService clienteService = new ClienteService();

    static {
        listaContaPessoal.add(new ContaPessoal(1212, 1, "123",
                clienteService.buscarCliente("Diego", "123")));
        listaContaPessoal.add(new ContaPessoal(1313, 2, "123",
                clienteService.buscarCliente("Gabriel", "321")));
    }

    public static Set buscarContas(){
        return Collections.unmodifiableSet(listaContaPessoal);
    }

}
