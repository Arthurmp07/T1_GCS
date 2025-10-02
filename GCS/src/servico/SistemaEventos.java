package servico;

import domain.Cliente;
import domain.Evento;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SistemaEventos {
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void menu() throws IOException {

        InicializarDados.inicializarDados();

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Listar eventos");
            System.out.println("2. Buscar evento por nome");
            System.out.println("3. Consultar detalhes de evento");
            System.out.println("4. Emitir ingresso");
            System.out.println("5. Registrar entrada de cliente");
            System.out.println("6. Listar presentes");
            System.out.println("7. Listar ausentes");
            System.out.println("8. Relatório mensal");
            System.out.println("9. Relatório anual");
            System.out.println("10. Ranking de Clientes VIP");
            System.out.println("11. Cancelar evento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> listarEventos();
                case 2 -> buscarEvento();
                case 3 -> consultarDetalhes();
                case 4 -> emitirIngresso();
                case 5 -> registrarEntrada();
                case 6 -> listarPresentes();
                case 7 -> listarAusentes();
                case 8 -> relatorioMensal();
                case 9 -> relatorioAnual();
                case 10 -> rankingClientesVIP();
                case 11 -> Cancelar();

                case 0 -> {
                    rodando = false;
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }


    private static void listarEventos() {
        if (Evento.getEventos().isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        System.out.println("=== Eventos cadastrados ===");
        for (Evento e : Evento.getEventos()) {
            System.out.printf("ID: %d | Nome: %s | Data: %s | Vagas: %d\n",
                    e.getEventoID(), e.getNome(), e.getDataEvento(), e.getQtdVagas());
        }
    }

    private static void buscarEvento() {
        System.out.print("Nome do evento para buscar: ");
        String nome = sc.nextLine();
        Buscar buscar = new Buscar();
        Evento e = buscar.buscarEventoporNome(Evento.getEventos(), nome);
        if (e != null) System.out.println(e);
    }

    private static Evento selecionarEvento() {
        listarEventos();
        System.out.print("Digite o ID do evento: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Evento e : Evento.getEventos()) {
            if (e.getEventoID() == id) return e;
        }
        System.out.println("Evento não encontrado.");
        return null;
    }

    private static void consultarDetalhes() {
        Evento e = selecionarEvento();
        if (e != null) e.consultarDetalhes(e);
    }

    private static void emitirIngresso() {
        Evento e = selecionarEvento();
        if (e == null) return;

        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, idade, null);
        EmitirIngresso emitir = new EmitirIngresso();
        emitir.emitir(e, cliente);

        System.out.println("Ingresso emitido para " + cliente.getNome());
    }

    private static void registrarEntrada() throws IOException {
        Evento e = selecionarEvento();
        if (e == null) return;

        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = null;
        for (Cliente c : e.getClientesComIngresso()) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        Iterator<Cliente> it = e.getClientesComIngresso().iterator();
        while(it.hasNext()) {
            Cliente c = it.next();
            if(c.getCpf().equals(cpf)) {
                it.remove();
                e.getClientesPresentes().add(c);
            }
        }
    }

    private static void listarPresentes() {
        Evento e = selecionarEvento();
        if (e != null) e.listaPresentes();
    }

    private static void listarAusentes() {
        Evento e = selecionarEvento();
        if (e != null) e.listarAusentes();
    }

    private static void relatorioMensal() {
        Evento e = selecionarEvento();
        if (e == null) return;

        System.out.print("Mês (1-12): ");
        int mes = sc.nextInt();
        sc.nextLine();
        RelatorioMensal relatorio = new RelatorioMensal();
        relatorio.gerar(LocalDate.of(LocalDate.now().getYear(), mes, 1), e);
    }

    private static void relatorioAnual() {
        Evento e = selecionarEvento();
        if (e == null) return;

        System.out.print("Ano (ex: 2025): ");
        int ano = sc.nextInt();
        sc.nextLine();
        RelatorioMensal relatorio = new RelatorioMensal();
        relatorio.listarAno(LocalDate.of(ano, 1, 1), e);
    }
    private static void rankingClientesVIP() {
        System.out.println("=== Ranking de Clientes VIP ===");
        List<Evento> eventos = Evento.getEventos();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento registrado ainda.");
            return;
        }

        RankingVIP.gerarRanking(eventos);
    }
    private static void Cancelar(){
        listarEventos();
        System.out.print("Digite o ID do evento que deseja cancelar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        for (Evento e : Evento.getEventos()) {
            if (e.getEventoID() == id) {
                Cancelar.cancelar(e);
                return;
            }
        }
        System.out.println("Evento não encontrado.");
        return;
    }

}
