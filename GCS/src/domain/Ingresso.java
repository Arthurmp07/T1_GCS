package domain;

public class Ingresso {
    protected Evento idEvento;
    protected String data;
    protected int idIngresso = 0;
    protected boolean isEspecial;

    public Ingresso(Evento idEvento, String data, boolean isEspecial) {
        this.idEvento = idEvento;
        this.data = data;
        this.idIngresso++; // NOTE soma 1 a cada instância
        this.isEspecial = isEspecial;
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

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }
}
