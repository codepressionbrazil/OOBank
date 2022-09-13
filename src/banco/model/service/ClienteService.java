package banco.model.service;

import banco.model.dao.ClienteDAO;
import banco.model.entities.Cliente;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteService {

    static ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente logar(String usuario, String senha) {
        try{
            ArrayList<Cliente> listaClientes = new ArrayList<>(ClienteDAO.buscarClientes());
            for (Cliente c : listaClientes) {
                if (c.getNome().equals(usuario) && c.getSenha().equals(senha)) {
                    return c;
                }
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return null;
    }


    public boolean cadastrar(String nome, String senha, String endereco, String cpf, String profissao, Double renda) {
        Cliente cliente = new Cliente(nome, endereco, cpf, profissao, renda, senha);
        try{
            return clienteDAO.cadastrar(cliente);
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
            return false;
        }
    }

    public String listarCLientes() throws SQLException {
        return ClienteDAO.buscarClientes().toString();
    }

    public Cliente buscarCliente(String usuario, String senha) {
        try{
            ArrayList<Cliente> listaCliente = new ArrayList<>(clienteDAO.buscarClientes());
            for (Cliente c : listaCliente) {
                if (c.getNome().equals(usuario) && c.getSenha().equals(senha)) {
                    return c;
                }
            }
        } catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Error no buscar clientes: " + err.getMessage());
        }
        return null;
    }
}
