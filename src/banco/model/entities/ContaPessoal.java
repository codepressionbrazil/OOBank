package banco.model.entities;

public class ContaPessoal {

    private Integer agencia, numero;
    private String senha;
    private String cliente_cpf;
    private Double saldo;


    public static void depositar() {
    }

    public static void sacar() {
    }

    @Override
    public String toString() {
        return "ContaPessoal --> " +
                " | Agencia: " + agencia +
                " | Número: " + numero +
                " | Senha: " + senha +
                " | Cliente: " + cliente_cpf +
                " | Saldo: " + saldo + "\n";
    }

    public ContaPessoal(Integer agencia, Integer numero, String senha, String cliente_cpf, Double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.cliente_cpf = cliente_cpf;
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

    public String getClienteCPF() {
        return cliente_cpf;
    }

    public void setCliente(String cliente) {
        this.cliente_cpf = cliente;
    }
}
