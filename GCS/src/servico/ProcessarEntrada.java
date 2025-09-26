package servico;

//Bibliotecas
import domain.Arquivos;
import domain.Cliente;
import domain.Evento;
import domain.Ingresso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessarEntrada {
    // Metodo para processar a entrada de clientes em um evento
    public static void processarEntrada(List<Cliente> clientesCarregados, Evento evento, Cliente cliente) throws IOException {

        // Adiciona todos os clientes carregados ao evento com ingresso
        for (Cliente c : clientesCarregados) {
            evento.adicionarClienteComIngresso(c);
        }

        // Registra a entrada de um cliente específico no evento
        evento.registrarEntrada(cliente);

        // Processa ausências (clientes que não entraram)
        evento.processarAusencias();

        // Lista os presentes no evento
        evento.listaPresentes();

        // Lista os ausentes no evento
        evento.listarAusentes();
    }
}
