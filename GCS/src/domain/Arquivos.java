package domain;

import java.nio.file.Path;

public enum Arquivos {
    EVENTOS(Path.of("eventos.ser")),
    INGRESSOS(Path.of("ingressos.ser")),
    CLIENTES(Path.of("clientes.ser"));

    private final Path value;

    public Path getValue() {
        return value;
    }

    Arquivos(Path value) {
        this.value = value;
    }
}
