package banco.model.entities;

public class ContaCredito extends ContaPessoal{

    private Double limite;

    public ContaCredito(Integer agencia, Integer numero, String senha, Cliente cliente, Double limite) {
        super(agencia, numero, senha, cliente, 0.0);
        this.limite = limite;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
}
