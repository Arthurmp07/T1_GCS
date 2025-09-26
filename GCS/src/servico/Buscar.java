package servico;

//Bibliotecas

import domain.Evento;
import java.util.List;

public class Buscar{
    // Metodo para buscar um evento pelo nome em uma lista de eventos
    public Evento buscarEventoporNome(List<Evento> eventos, String buscaNome) {
        // Verifica se a lista é nula ou está vazia
        if (eventos == null || eventos.isEmpty()) {
            System.out.println("Nenhum evento encontrado.");
            return null; // retorna null caso não haja eventos
        }
        // Percorre todos os eventos da lista
        for (Evento evento : eventos) {
            // Verifica se o nome do evento contém o termo buscado (ignora maiúsculas/minúsculas)
            if (evento.getNome().toLowerCase().contains(buscaNome.toLowerCase()))
                return evento; // retorna o evento encontrado
        }
        // Caso nenhum evento corresponda ao termo de busca
            System.out.println("Nenhum evento foi encontrado a partir deste termo." +buscaNome);
        return null;

    }
}
