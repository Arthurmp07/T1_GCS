package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Evento implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return eventoID == evento.eventoID && valor == evento.valor && qtdVagas == evento.qtdVagas && Objects.equals(nome, evento.nome) && Objects.equals(descricao, evento.descricao) && Objects.equals(eventos, evento.eventos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventoID, nome, descricao, valor, qtdVagas, eventos);
    }

    /** TODO:
     *      add evento
     *      list ingressos disp
     *      qtd de cada tipo (comum e especial)
     *      % de cada tipo (comum e especial)
     *      % de ocupação total
     *      list eventos**/



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

    /** NOTE
     *      métodos uteis **/

    public void listEventos(){
        eventos.forEach(Evento::toString);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "eventoID=" + eventoID +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", qtdVagas=" + qtdVagas +
                ", eventos=" + eventos +
                '}';
    }

    // Procura evento
    /** TODO
     *      selecionar E ENTÃO mostrar detalhes PARA ENTÃO alterar evento **/
    public void searchEventos(String nome){
        for(Evento evento : eventos){
            if(evento.nome.equalsIgnoreCase(nome)){
                evento.toString();
                return;
            }
        }
        System.out.println("Evento não encontrado por nome.");
    }

}
