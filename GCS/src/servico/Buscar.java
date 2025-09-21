package servico;

import domain.Evento;
import java.util.List;

public class Buscar{
    public Evento buscarEventoporNome(List<Evento> eventos, String buscaNome) {
        if (eventos == null || eventos.isEmpty()) {
            System.out.println("Nenhum evento encontrado.");
            return null;
        }
        for (Evento evento : eventos) {
            if (evento.getNome().toLowerCase().contains(buscaNome.toLowerCase()))
                return evento;
        }
            System.out.println("Nenhum evento foi encontrado a partir deste termo." +buscaNome);
        return null;
        
    }
}
