package banco.model.entities;

public class ContaCorrente extends ContaPessoal {

    private Double limite;

    public static void tranferir() {
    }

    public ContaCorrente(Integer agencia, Integer numero, String senha, Cliente cliente, Double limite) {
        super(agencia, numero, senha, cliente);
        this.limite = limite;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
}
