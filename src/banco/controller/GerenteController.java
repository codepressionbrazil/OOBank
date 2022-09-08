package banco.controller;

import banco.model.entities.Gerente;
import banco.model.service.ClienteService;
import banco.model.service.GerenteService;

public class GerenteController {

    static GerenteService gerenteService = new GerenteService();

    public boolean logar(String usuario, String senha) {
        return new GerenteService().logar(usuario, senha);
    }

    public boolean cadastrarCliente(String nome, String senha, String endereco, String cpf, String profissao, Double renda) {
        return new ClienteService().cadastrar(nome, senha, endereco, cpf, profissao, renda);
    }

    public String listarClientes() {
        return new ClienteService().listarCLientes();
    }

    public Gerente buscarGerente(String usuario, String senha) {
        return gerenteService.buscarGerente(usuario, senha);
    }
}
