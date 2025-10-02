package servico;

import domain.Cliente;
import domain.Evento;
import domain.Ingresso;


public class EmitirIngresso {
    public void emitir(Evento evento, Cliente cliente) {
        if (!evento.clienteTemIngresso(cliente)) {
            Ingresso ingresso = new Ingresso(evento, "0", false);
            cliente.setIngresso(ingresso);
            evento.adicionarClienteComIngresso(cliente);
        }
    }
}
