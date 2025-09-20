package domain;

import java.io.Serializable;
import java.util.Objects;

public class Ingresso implements Serializable {
    protected Evento evento;
    protected String data;
    protected int idIngresso = 0;
    protected boolean isEspecial;

    public Ingresso(Evento evento, String data, boolean isEspecial) {
        this.evento = evento;
        this.data = data;
        this.idIngresso++; // NOTE soma 1 a cada instância
        this.isEspecial = isEspecial;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ingresso ingresso = (Ingresso) o;
        return idIngresso == ingresso.idIngresso && isEspecial == ingresso.isEspecial && Objects.equals(evento, ingresso.evento) && Objects.equals(data, ingresso.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evento, data, idIngresso, isEspecial);
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "evento=" + evento +
                ", data='" + data + '\'' +
                ", idIngresso=" + idIngresso +
                ", isEspecial=" + isEspecial +
                '}';
    }

    /** TODO
     *      15% especial *COM BASE NA QUANTIDADE DE INGRESSOS DO EVENTOS*
     *      não sei mais, finalizar? :)**/



    public boolean isEspecial() {
        return isEspecial;
    }

    public void setEspecial(boolean especial) {
        isEspecial = especial;
    }

    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
