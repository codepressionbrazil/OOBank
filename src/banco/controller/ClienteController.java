package banco.controller;

import banco.model.service.ClienteService;

public class ClienteController {

    static ClienteService clienteService = new ClienteService();

    public boolean logar(String usuario, String senha) {
        return new ClienteService().logar(usuario, senha);
    }
}
