package servico;

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
    protected static List<Evento> eventos = new ArrayList<>();
    protected static List<Ingresso> ingressos = new ArrayList<>();
    protected static List<Cliente> clientes = new ArrayList<>();


    public static <T> List<T> deserializer(Path path) throws IOException {
        if (Files.notExists(path)) {
            throw new FileNotFoundException("Arquivo nao encontrado: " + path);
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Object o = ois.readObject();
            if (o instanceof List<?> list) {
                for (Object object : list) {
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

        } catch (ClassNotFoundException e) {
            throw new IOException("Classe nao encontrada ao desserializar", e);
        }
        return Collections.emptyList();
    }

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
