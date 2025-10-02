package servico;

import domain.Cliente;
import domain.Evento;

import java.util.*;
import java.util.stream.Collectors;

public class RankingVIP {

    public static void gerarRanking(List<Evento> eventos) {

        Map<Cliente, ClienteStats> statsMap = new HashMap<>();

        for (Evento e : eventos) {
            for (Cliente c : e.getClientesComIngresso()) {
                statsMap.putIfAbsent(c, new ClienteStats());
                ClienteStats stats = statsMap.get(c);
                stats.eventosParticipados++;
                if (c.getIngresso().isEspecial()) {
                    stats.ingressosEspeciais++;
                }
                if (e.getClientesPresentes().contains(c)) {
                    stats.presencas++;
                }
            }
        }


        List<Map.Entry<Cliente, ClienteStats>> ranking = statsMap.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().eventosParticipados, a.getValue().eventosParticipados))
                .collect(Collectors.toList());

        // Imprime ranking
        System.out.println("=== Ranking de Clientes VIP ===");
        int pos = 1;
        for (Map.Entry<Cliente, ClienteStats> entry : ranking) {
            Cliente c = entry.getKey();
            ClienteStats s = entry.getValue();
            double percentualPresenca = (s.eventosParticipados == 0) ? 0 :
                    ((double) s.presencas * 100 / s.eventosParticipados);
            System.out.printf("%d. %s - %d eventos, %d ingressos especiais, %.2f%% presença%n",
                    pos++, c.getNome(), s.eventosParticipados, s.ingressosEspeciais, percentualPresenca);
        }

        if (ranking.isEmpty()) {
            System.out.println("Nenhum cliente registrado ainda.");
        }
    }


    private static class ClienteStats {
        int eventosParticipados = 0;
        int ingressosEspeciais = 0;
        int presencas = 0;
    }
}
