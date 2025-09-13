package domain;

public class Cliente {
    protected String nome;
    protected String cpf;
    protected int idade;
    protected Ingresso ingresso;

    public Cliente(String nome, String cpf, int idade, Ingresso ingresso) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.ingresso = ingresso;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
}
