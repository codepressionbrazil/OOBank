package banco.controller;

import banco.model.entities.Cliente;
import banco.model.service.ClienteService;

public class ClienteController {

    static ClienteService clienteService = new ClienteService();

    public static void buscarDadosBD() {
        clienteService.buscarDadosBD();
    }

    public Cliente logar(String usuario, String senha) {
        return new ClienteService().logar(usuario, senha);
    }

    public Cliente buscarCliente(String usuario, String senha) {
        return clienteService.buscarCliente(usuario, senha);
    }
}
