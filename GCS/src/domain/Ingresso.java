package domain;

import java.io.Serializable;
import java.util.Objects;

public class Ingresso implements Serializable {

    protected Evento evento;
    protected String codigo;
    protected boolean isEspecial;
    protected int idIngresso = 0;
    protected String data;

    public Ingresso(Evento evento, String codigo, boolean isEspecial, String data) {
        this.evento = evento;
        this.codigo = codigo;
        this.isEspecial = isEspecial;
        this.idIngresso++; // NOTE soma 1 a cada instância
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ingresso ingresso = (Ingresso) o;
        return isEspecial == ingresso.isEspecial &&
                Objects.equals(evento, ingresso.evento) &&
                Objects.equals(codigo, ingresso.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evento, codigo, isEspecial);
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "evento=" + evento.getNome() +
                ", codigo='" + codigo + '\'' +
                ", especial=" + isEspecial +
                '}';
    }


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
