package banco.model.entities;

public class Cliente {

    private String nome, endereco, cpf, profissao, senha;
    private Double renda;

    public Cliente(String nome, String endereco, String cpf, String profissao, Double renda, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.profissao = profissao;
        this.renda = renda;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente --> " +
                "Nome: " + nome +
                "Endereco: " + endereco +
                "Cpf: " + cpf +
                "Profissao: " + profissao +
                "Senha: " + senha +
                "Renda: " + renda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
