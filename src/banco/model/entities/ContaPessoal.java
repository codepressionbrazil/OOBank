package banco.model.entities;

public class ContaPessoal {

    private Integer agencia, numero;
    private String senha;
    private Cliente cliente;

    public static void depositar() {
    }

    public static void sacar() {
    }

    public ContaPessoal(Integer agencia, Integer numero, String senha, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.cliente = cliente;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
