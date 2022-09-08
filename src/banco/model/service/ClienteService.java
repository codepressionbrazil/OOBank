package banco.model.service;

import banco.model.dao.ClienteDAO;
import banco.model.entities.Cliente;

import java.util.ArrayList;

public class ClienteService {

    static ClienteDAO clienteDAO = new ClienteDAO();

    public boolean logar(String usuario, String senha) {
        ArrayList<Cliente> listaClientes = new ArrayList<>(ClienteDAO.buscarClientes());
        for (Cliente c : listaClientes) {
            if (c.getNome().equals(usuario) && c.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }


    public boolean cadastrar(String nome, String senha, String endereco, String cpf, String profissao, Double renda) {
        Cliente cliente = new Cliente(nome, endereco, cpf, profissao, renda, senha);
        return clienteDAO.cadastrar(cliente);
    }

    public String listarCLientes() {
        return ClienteDAO.buscarClientes().toString();
    }

    public Cliente buscarCliente(String usuario, String senha) {
        ArrayList<Cliente> listaCliente = new ArrayList<>(clienteDAO.buscarCliente());
        for (Cliente c : listaCliente) {
            if (c.getNome().equals(usuario) && c.getSenha().equals(senha)) {
                return c;
            }
        }
        return null;
    }
}
