package banco.model.dao;

import banco.model.entities.Cliente;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClienteDAO {
    private static Set<Cliente> listaClientes = new HashSet<>();

    static {
        listaClientes.add(new Cliente("Diego", "Rua tal", "123", "DEV BACKEND", 7000.00, "123"));
        listaClientes.add(new Cliente("Gabriel", "Rua tal", "321", "DEV FRONTEND", 5000.00, "321"));
        listaClientes.add(new Cliente("Leonardo", "Rua tal", "456", "DEV BACKEND", 10000.00, "456"));
    }


    public static Set buscarClientes() {
        return Collections.unmodifiableSet(listaClientes);
    }

    public boolean cadastrar(Cliente cliente) {
        listaClientes.add(cliente);
        return true;
    }

    public Set buscarCliente() {
        return Collections.unmodifiableSet(listaClientes);
    }
}
