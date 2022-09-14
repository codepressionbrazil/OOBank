package banco.model.service;

import banco.model.dao.GerenteDAO;
import banco.model.entities.Cliente;
import banco.model.entities.Gerente;

import java.util.ArrayList;

public class GerenteService {

    public Gerente logar(String usuario, String senha) {
        ArrayList<Gerente> listaGerentes = new ArrayList<>(GerenteDAO.buscarGerentes());
        for(Gerente g : listaGerentes){
            if(g.getNome().equals(usuario) && g.getSenha().equals(senha)){
                return g;
            }
        }
        return null;
    }

    public Gerente buscarGerente(String usuario, String senha) {
        ArrayList<Gerente> listaGerente = new ArrayList<>(GerenteDAO.buscarGerentes());
        for(Gerente g : listaGerente){
            if(g.getNome().equals(usuario) && g.getSenha().equals(senha)){
                return g;
            }
        }
        return null;
    }

    public void buscarDadosBD() {
//        String sqlCommand = "select * from gerentes";
//        pstm = conn.prepareStatement(sqlCommand);
//        rs = pstm.executeQuery();
//        while(rs.next()){
//            listaClientes.add(new Cliente(rs.getString("nome"),
//                    rs.getString("endereco"),
//                    rs.getString("cpf"),
//                    rs.getString("profissao"),
//                    rs.getDouble("renda"),
//                    rs.getString("senha")
//            ));
//        }
    }
}
