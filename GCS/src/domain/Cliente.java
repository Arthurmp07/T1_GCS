package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente implements Serializable {
    protected String nome;
    protected String cpf;
    protected int idade;
    protected Ingresso ingresso;
    private boolean presente = false;
    protected List<Cliente> clientes = new ArrayList<>();

    public Cliente(String nome, String cpf, int idade, Ingresso ingresso) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.ingresso = ingresso;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", ingresso=" + ingresso +
                ", presente=" + presente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idade == cliente.idade && presente == cliente.presente && Objects.equals(nome, cliente.nome) && Objects.equals(cpf, cliente.cpf) && Objects.equals(ingresso, cliente.ingresso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, idade, ingresso, presente);
    }

    /** TODO
     *      verificação no SET para apenas no dia do evento **/

    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
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

    public List<Cliente> getClientes() {return clientes;}

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
