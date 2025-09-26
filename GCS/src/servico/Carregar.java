package servico;

//Bibliotecas
import domain.Arquivos;
import domain.Cliente;
import domain.Evento;
import domain.Ingresso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carregar {
    // Listas estáticas que armazenam todos os objetos carregados
    protected static List<Evento> eventos = new ArrayList<>();
    protected static List<Ingresso> ingressos = new ArrayList<>();
    protected static List<Cliente> clientes = new ArrayList<>();

    // Metodo genérico para desserializar uma lista de objetos de um arquivo
    public static <T> List<T> deserializer(Path path) throws IOException {
        // Verifica se o arquivo existe
        if (Files.notExists(path)) {
            throw new FileNotFoundException("Arquivo nao encontrado: " + path);
        }

        // Abre o arquivo para leitura de objetos
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Object o = ois.readObject(); // Lê o objeto serializado

            // Verifica se o objeto lido é uma lista
            if (o instanceof List<?> list) {
                // Percorre todos os objetos da lista
                for (Object object : list) {
                    // Adiciona cada objeto na lista correta se ainda não estiver nela
                    if (object instanceof Evento evento){
                        if (!eventos.contains(evento)){
                            eventos.add(evento);
                        }
                    }
                    if (object instanceof Cliente cliente){
                        if (!clientes.contains(cliente)){
                            clientes.add(cliente);
                        }
                    }
                    if (object instanceof Ingresso ingresso){
                        if (!ingressos.contains(ingresso)){
                            ingressos.add(ingresso);
                        }
                    }
                }
            }

            // Tratamento caso a classe dos objetos não seja encontrada
        } catch (ClassNotFoundException e) {
            throw new IOException("Classe nao encontrada ao desserializar", e);
        }

        // Retorna lista vazia (pois os objetos foram adicionados em listas estáticas)
        return Collections.emptyList();
    }

    // Métodos para acessar as listas carregadas
    public static List<Evento> getEventos() {
        return eventos;
    }

    public static List<Ingresso> getIngressos() {
        return ingressos;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
