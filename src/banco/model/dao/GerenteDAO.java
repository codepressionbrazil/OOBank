package banco.model.dao;

import banco.model.entities.Gerente;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GerenteDAO {

    private static Set<Gerente> listaGerentes = new HashSet<>();

    static {
        listaGerentes.add(new Gerente("Diego", "Rua tal", "123", "DEV BACKEND", 7000.00, "123"));
        listaGerentes.add(new Gerente("Gabriel", "Rua tal", "321", "DEV FRONTEND", 5000.00, "321"));
        listaGerentes.add(new Gerente("Leonardo", "Rua tal", "456", "DEV BACKENDDDDDDDDDDDD", 1000000000.00, "456"));
    }

    public static Set buscarGerentes() {
        return Collections.unmodifiableSet(listaGerentes);
    }

}
