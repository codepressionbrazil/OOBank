package banco.model.entities;

public class ContaPoupanca extends ContaPessoal{

    private Double rendimento;

    public ContaPoupanca(Integer agencia, Integer numero, String senha, Cliente cliente, Double rendimento) {
        super(agencia, numero, senha, cliente, 0.0);
        this.rendimento = rendimento;
    }

    public Double getRendimento() {
        return rendimento;
    }

    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }
}
