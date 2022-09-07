package banco.model.service;

import banco.model.dao.GerenteDAO;
import banco.model.entities.Gerente;

import java.util.ArrayList;

public class GerenteService {
    public boolean logar(String usuario, String senha) {
        ArrayList<Gerente> listaGerentes = new ArrayList<>(GerenteDAO.buscarGerentes());
        for(Gerente g : listaGerentes){
            if(g.getNome().equals(usuario) && g.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
