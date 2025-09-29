package servico;

import domain.Evento;
import java.util.Scanner;
import java.time.LocalDate;

public class Cancelar {
    public static void cancelar(Evento evento) {
        Scanner sc = new Scanner(System.in);

        if(evento.getDataEvento().isBefore(LocalDate.now())) {
            System.out.println("Evento já ocorreu e não pode ser cancelado");
            return;
        }

        System.out.println("Tem certeza que deseja cancelar?");
        System.out.println("[1] - Sim");
        System.out.println("[0] - Não");
        int decisao = sc.nextInt();

        if(decisao==0){
            System.out.println("Evento não foi cancelado");
            return;
        }
        evento.getIngressos().clear();

        //TODO: Atualizar a lista de eventos após correção da classe Evento().
    }
}
