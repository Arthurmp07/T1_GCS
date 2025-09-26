package servico;

//Bibliotecas
import domain.Cliente;
import domain.Evento;
import domain.Ingresso;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Salvar {

    // Metodo genérico para serializar (salvar) uma lista de objetos em um arquivo
    public static <T> void serializer(List<T> list, Path path) throws IOException {
        // Caso o arquivo ainda não exista, cria-o
        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        // Abre o arquivo para escrita e grava a lista de objetos
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(list); // serializa a lista

            // Caso ocorra algum erro de execução
        } catch (RuntimeException e) {
            throw new RuntimeException("Nao foi possivel serializar");
        }
    }
}
