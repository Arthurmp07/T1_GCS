package servico;

import domain.Arquivos;
import domain.Cliente;
import domain.Evento;
import domain.Ingresso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessarEntrada {
    public static void processarEntrada(List<Cliente> clientesCarregados, Evento evento, Cliente cliente) throws IOException {

        for(Cliente c : clientesCarregados) {
            evento.adicionarClienteComIngresso(c);
        }

        evento.registrarEntrada(cliente);

        evento.processarAusencias();
        evento.listaPresentes();
        evento.listarAusentes();
    }
}
