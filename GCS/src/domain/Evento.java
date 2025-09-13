package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Evento {
    protected int eventoID;
    protected String nome;
    protected String descricao;
    protected int valor;
    protected int qtdVagas;

    List<Evento> eventos = new ArrayList<>();

    public Evento(String nome, String descricao, int valor, int qtdVagas) {
        this.eventoID = ThreadLocalRandom.current().nextInt(100, 999);
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdVagas = qtdVagas;
    }

    /** TODO:
     *      add evento
     *      list ingressos disp
     *      qtd de cada tipo (comum e especial)
     *      % de cada tipo (comum e especial)
     *      % de ocupação total **/

    public int getEventoID() {
        return eventoID;
    }

    public void setEventoID(int eventoID) {
        this.eventoID = eventoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
