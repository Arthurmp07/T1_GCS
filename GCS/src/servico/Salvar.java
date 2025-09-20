package servico;

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



    public static <T> void serializer(List<T> list, Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(list);

        } catch (RuntimeException e) {
            throw new RuntimeException("Nao foi possivel serializar");
        }
    }


}
