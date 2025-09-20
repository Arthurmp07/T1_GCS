package main;



import domain.Arquivos;
import domain.Cliente;
import domain.Evento;
import domain.Ingresso;
import servico.Carregar;
import servico.Salvar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        //para carregar uma lista da memoria voce ira utilizar Carregar.deserializer(Arquivos.(o nome da class).getValues());
        //para salvar uma lista para a memoria voce ira utlizar Salvar.serializer(Tua lista, Arquivos.(o nome da classe).getValues())
        //para pegar os valores carregados voce ira fazer List<(o nome da class)> lista = Carregar.get(o nome da class);

        Evento evento = new Evento("the town", "musicas foda", 1000, 3);
        List<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente("Carlos", "1111111111111111", 53, new Ingresso(evento, "25/11/2025", false)),
                new Cliente("Maria Helena", "22222222222", 2,  new Ingresso(evento, "25/11/2025", true)),
                new Cliente("Josep", "33333333333", 76, new Ingresso(evento, "25/11/2025", false))
        ));
        Salvar.serializer(clientes, Arquivos.CLIENTES.getValue());
        Carregar.deserializer(Arquivos.CLIENTES.getValue());
        List<Cliente> clientesSerealizacao = Carregar.getClientes();
        clientesSerealizacao.get(0).getIngresso().getEvento().registrarEntrada(clientesSerealizacao.get(0));
        clientesSerealizacao.get(1).getIngresso().getEvento().registrarEntrada(clientesSerealizacao.get(1));
        Evento evento2 = clientesSerealizacao.get(0).getIngresso().getEvento();
        List<Cliente> clientes3 = evento2.getClientesRegistrados();
        int c = 0;
        for(Cliente cliente : clientesSerealizacao) {
            if(clientes3.contains(cliente)){
                System.out.println(cliente.getNome());
                c++;
            }
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        List<Cliente> clientesRegistrados = evento2.getClientesRegistrados();
        for(int i = 0; i < clientesSerealizacao.size(); i++) {
            if(!clientesRegistrados.contains(clientesSerealizacao.get(i))){
                evento2.setClientesNaoCompareceram(clientesSerealizacao.get(i));
                System.out.println(clientesSerealizacao.get(i).getNome());
            }
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(evento2.getClientesNaoCompareceram());

    }
}

