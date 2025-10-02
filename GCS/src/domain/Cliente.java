package domain;

 //Bibliotecas
import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

    //Atributos
    protected String nome;
    protected String cpf;
    protected int idade;
    protected Ingresso ingresso;
    private boolean presente = false;


    //Construtor
    public Cliente(String nome, String cpf, int idade, Ingresso ingresso) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.ingresso = ingresso;
    }

    //Getters e Setters


    public String getNome() {
        return nome;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }
    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }



    public String getCpf() {
        return cpf;
    }


    //Comparador de objetos por sobrescrita


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    //Retorno
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
}
