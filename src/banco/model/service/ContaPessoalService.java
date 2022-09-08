package banco.model.service;

import banco.controller.ContaPessoalController;
import banco.model.dao.ContaPessoalDAO;
import banco.model.entities.Cliente;
import banco.model.entities.ContaPessoal;

import java.util.ArrayList;

public class ContaPessoalService {
    public ContaPessoal buscarConta(Cliente cliente) {
        ContaPessoalDAO contaPessoalDao = new ContaPessoalDAO();
        ArrayList<ContaPessoal> contas = new ArrayList<>(contaPessoalDao.buscarContas());
        
        for(ContaPessoal contaPessoal : contas){
            if(contaPessoal.getCliente().equals(cliente)){
                return contaPessoal;
            }
        }
        return null;
    }
}
