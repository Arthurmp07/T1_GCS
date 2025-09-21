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
    protected List<Cliente> clientesPresentes = new ArrayList<>();
    protected List<Cliente> clientesAusentes = new ArrayList<>();
    protected List<Cliente> clientesComIngresso = new  ArrayList<>();
    protected int vagasOcupadas;

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

    public int getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public List<Cliente> getClientesPresentes() {
        return clientesPresentes;
    }

    public void setClientesPresentes(List<Cliente> clientesPresentes) {
        this.clientesPresentes = clientesPresentes;
    }

    public List<Cliente> getClientesAusentes() {
        return clientesAusentes;
    }

    public void setClientesAusentes(Cliente clienteNaoCompareceram) {
        this.clientesAusentes.add(clienteNaoCompareceram);
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

    public boolean clienteTemIngresso(Cliente cliente) {
        return cliente.getIngresso() != null &&
               cliente.getIngresso().getEvento().getEventoID() == this.eventoID &&
               clientesComIngresso.contains(cliente);
    }

    public boolean registrarEntrada(Cliente c) {
        if(!clienteTemIngresso(c)) {
            System.out.println(c.getNome() + " não possui ingresso");
            return false;
        }
        if(clientesPresentes.contains(c)){
            System.out.println(c.getNome() + " já está na lista");
            return false;
        }
        clientesAusentes.remove(c);
        clientesPresentes.add(c);
        vagasOcupadas++;
        System.out.println("Entrada registrada com sucesso");
        return true;
    }

    public boolean adicionarClienteComIngresso(Cliente c){
        if(clientesComIngresso.size() <= qtdVagas) {
            clientesComIngresso.add(c);
            return true;
        }
        System.out.println("Não há mais vagas disponíveis");
        return false;
    }

    public void processarAusencias() {
        clientesAusentes.clear();
        for(Cliente cliente : clientesComIngresso){
            if(!clientesPresentes.contains(cliente)){
                clientesAusentes.add(cliente);
            }
        }
    }

    public void listarAusentes() {
        System.out.println("Listar ausentes:");
        if(clientesAusentes.isEmpty()) {
            System.out.println("Nenhum cliente registrado");
        } else {
            for(Cliente cliente : clientesAusentes){
                System.out.println(cliente.getNome());
            }
        }
    }

    public void listaPresentes() {
        System.out.println("Listar presentes:");
        if(clientesPresentes.isEmpty()){
            System.out.println("Nenhum cliente registrado");
        } else {
            for(Cliente cliente : clientesPresentes){
                System.out.println(cliente.getNome());
            }
        }
    }

}
