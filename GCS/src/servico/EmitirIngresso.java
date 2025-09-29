package servico;

import domain.Cliente;
import domain.Evento;
import domain.Ingresso;

import java.util.List;

public class EmitirIngresso {
    public void emitir(Evento evento, Cliente cliente){

        List<Evento> eventos = Evento.getEventos();
            for (Evento evento1 : eventos) {
                if (!evento1.clienteTemIngresso(cliente)) {
                    Ingresso ingresso = new Ingresso(evento1, "53", false);
                    cliente.setIngresso(ingresso);
                    evento1.adicionarClienteComIngresso(cliente);
                }
        }

    }
}
