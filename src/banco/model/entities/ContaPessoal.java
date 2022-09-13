package banco.model.entities;

public class ContaPessoal {

    private Integer agencia, numero;
    private String senha;
    private Cliente cliente;
    private Double saldo;


    public static void depositar() {
    }

    public static void sacar() {
    }

    @Override
    public String toString() {
        return "ContaPessoal --> " +
                "Agencia: " + agencia +
                "\nNúmero: " + numero +
                "\nSenha: " + senha +
                "\nCliente: " + cliente +
                "\nSaldo: " + saldo;
    }

    public ContaPessoal(Integer agencia, Integer numero, String senha, Cliente cliente, Double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
