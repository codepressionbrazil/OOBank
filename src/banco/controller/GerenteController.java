package banco.controller;

import banco.model.entities.Gerente;
import banco.model.service.ClienteService;
import banco.model.service.GerenteService;

import javax.swing.*;
import java.sql.SQLException;

public class GerenteController {

    static GerenteService gerenteService = new GerenteService();

    public Gerente logar(String usuario, String senha) {
        return new GerenteService().logar(usuario, senha);
    }

    public boolean cadastrarCliente(String nome, String senha, String endereco, String cpf, String profissao, Double renda) {
        return new ClienteService().cadastrar(nome, senha, endereco, cpf, profissao, renda);
    }

    public String listarClientes() {
        try{
            return new ClienteService().listarCLientes();
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return "Error, não cadastrou";
    }

    public Gerente buscarGerente(String usuario, String senha) {
        return gerenteService.buscarGerente(usuario, senha);
    }
}
