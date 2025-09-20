package domain;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.time.LocalDate;

public class Evento implements Serializable {
    protected int eventoID;
    protected String nome;
    protected String descricao;
    protected int valor;
    protected int qtdVagas;
    protected LocalDate dataEvento;

    List<Evento> eventos = new ArrayList<>();
    List<Ingresso> ingressos = new ArrayList<>();

    public Evento(String nome, String descricao, int valor, int qtdVagas, LocalDate dataEvento) {

        if (nome == null || nome.isBlank() || descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Nome e descrição não podem ser nulos ou vazios.");
        if (qtdVagas <= 0)
            throw new IllegalArgumentException("Quantidade de vagas deve ser positiva.");
        if (dataEvento == null || !dataEvento.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("A data do evento deve ser futura.");

        this.eventoID = ThreadLocalRandom.current().nextInt(100, 999);
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdVagas = qtdVagas;
        this.dataEvento = dataEvento;

        gerarIngressos();
    }

    private void gerarIngressos() {
        int qtdEspeciais = (int) Math.ceil(qtdVagas * 0.15);
        int qtdComuns = qtdVagas - qtdEspeciais;


        for (int i = 1; i <= qtdComuns; i++) {
            String codigo = String.format("%d-%03d", eventoID, i);
            ingressos.add(new Ingresso(this, codigo, false, dataEvento.toString()));
        }


        for (int i = qtdComuns + 1; i <= qtdVagas; i++) {
            String codigo = String.format("%d-%03dE", eventoID, i);
            ingressos.add(new Ingresso(this, codigo, true, dataEvento.toString()));
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return eventoID == evento.eventoID &&
                valor == evento.valor &&
                qtdVagas == evento.qtdVagas &&
                Objects.equals(nome, evento.nome) &&
                Objects.equals(descricao, evento.descricao) &&
                Objects.equals(eventos, evento.eventos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventoID, nome, descricao, valor, qtdVagas, eventos);
    }

    /** TODO FUTURO:
     *      - add evento
     *      - list ingressos disp
     *      - qtd de cada tipo (comum e especial)
     *      - % de cada tipo (comum e especial)
     *      - % de ocupação total
     *      - list eventos
     **/


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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }


    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void listEventos(){
       if (eventos.isEmpty()){
           System.out.println("Nenhum evento cadastrado.");
            return;
        }
       for(Evento e : eventos){
           System.out.printf("%d;%s;%s;%d;%d%n:",
                   e.eventoID, e.nome, e.descricao, e.valor, e.qtdVagas);
       }

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
                ", dataEvento=" + dataEvento +
                '}';
    }


    public void searchEventos(String nome) {
        for (Evento evento : eventos) {
            if (evento.nome.equalsIgnoreCase(nome)) {
                System.out.println(evento.toString());
                return;
            }
        }
        System.out.println("Evento não encontrado por nome.");
    }
}
