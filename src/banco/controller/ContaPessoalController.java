package banco.controller;

import banco.model.entities.ContaCredito;
import banco.model.entities.ContaPessoal;
import banco.model.service.ContaPessoalService;

public class ContaPessoalController {
    public void sacar(ContaPessoal c) {
        if(c instanceof ContaCredito){
            ContaPessoalService.sacar(c);
        }
    }
}
