package servico;

import domain.Evento;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class RelatorioMensal {
    public void gerar(LocalDate mesTarget, Evento evento){
        List<Evento> eventos = evento.getEventos();


        System.out.println("=== eventos do mes ===");
        for (Evento evento1 : eventos) {
            int value = evento1.getDataEvento().getMonth().getValue();
            if (value == mesTarget.getMonthValue()) {

                System.out.println("nome evento " + evento1.getNome());
                System.out.println("data " + evento1.getDataEvento());
                System.out.println("valor " + evento1.getValor());
                System.out.println("vagas " + evento1.getQtdVagas());
                System.out.println("descrição " + evento1.getDescricao());
            }
        }


    }

    public void listarAno(LocalDate data, Evento evento){
        List<Evento> eventos = evento.getEventos();
        System.out.println("=== eventos do ano ===");
        for (Evento evento1 : eventos) {
            int value = evento1.getDataEvento().getYear();
            if (value == data.getYear()) {
                System.out.println("nome evento " + evento1.getNome());
                System.out.println("data " + evento1.getDataEvento());

            }
        }
    }
}
