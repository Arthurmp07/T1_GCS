package servico;

import domain.Cliente;
import domain.Evento;

import java.time.LocalDate;
import java.util.List;

public class InicializarDados {
    public static void inicializarDados() {
        try {
            // Criar eventos de exemplo
            Evento evento1 = new Evento("Rock Festival", "Festival de rock com várias bandas", 150, 5, LocalDate.of(2025, 11, 25));
            Evento evento2 = new Evento("Jazz Night", "Noite de jazz com artistas renomados", 200, 3, LocalDate.of(2025, 12, 10));
            Evento evento3 = new Evento("Tech Conference", "Conferência sobre tecnologia", 500, 10, LocalDate.of(2025, 12, 15));
            Evento evento4 = new Evento("Food Carnival", "Festival gastronômico", 100, 7, LocalDate.of(2025, 11, 28));
            Evento evento5 = new Evento("Art Expo", "Exposição de arte moderna", 250, 4, LocalDate.of(2025, 12, 5));

            Evento.addEventos(evento1);
            Evento.addEventos(evento2);
            Evento.addEventos(evento3);
            Evento.addEventos(evento4);
            Evento.addEventos(evento5);

            // Criar clientes
            List<Cliente> clientes = List.of(
                    new Cliente("Alice", "11111111111", 30, null),
                    new Cliente("Bob", "22222222222", 25, null),
                    new Cliente("Carol", "33333333333", 28, null),
                    new Cliente("David", "44444444444", 35, null),
                    new Cliente("Eve", "55555555555", 22, null),
                    new Cliente("Frank", "66666666666", 40, null),
                    new Cliente("Grace", "77777777777", 31, null),
                    new Cliente("Heidi", "88888888888", 27, null),
                    new Cliente("Ivan", "99999999999", 33, null),
                    new Cliente("Judy", "00000000000", 29, null)
            );

            // Emitir ingressos e distribuir clientes nos eventos
            EmitirIngresso emitir = new EmitirIngresso();

            emitir.emitir(evento1, clientes.get(0)); // Alice
            emitir.emitir(evento1, clientes.get(1)); // Bob
            emitir.emitir(evento1, clientes.get(2)); // Carol

            emitir.emitir(evento2, clientes.get(3)); // David
            emitir.emitir(evento2, clientes.get(4)); // Eve

            emitir.emitir(evento3, clientes.get(5)); // Frank
            emitir.emitir(evento3, clientes.get(6)); // Grace
            emitir.emitir(evento3, clientes.get(7)); // Heidi

            emitir.emitir(evento4, clientes.get(8)); // Ivan
            emitir.emitir(evento4, clientes.get(9)); // Judy

            // Não atribuir clientes para o evento5 para testar eventos vazios
        } catch (Exception e) {
            System.out.println("Erro ao inicializar dados: " + e.getMessage());
        }
    }
}
