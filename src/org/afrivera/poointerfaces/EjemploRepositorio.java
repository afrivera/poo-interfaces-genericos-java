package org.afrivera.poointerfaces;

import org.afrivera.poointerfaces.modelo.Cliente;
import org.afrivera.poointerfaces.repositorio.*;
import org.afrivera.poointerfaces.repositorio.list.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Bea", "Gonzalez"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Andres", "Rivera"));

        List<Cliente> clientes =repo.listar();
        // clientes.forEach(cliente -> System.out.println(cliente)); se puede resumir
        clientes.forEach(System.out::println);
        System.out.println("=".repeat(40));
        List<Cliente> paginable = repo.listar(1, 3);// indice 1 y indice 2 excluye el 3
        paginable.forEach(System.out::println);
        System.out.println("=".repeat(40));
        List<Cliente> clienteOrdenAsc = repo.listar("nombre", Direccion.ASC);

        for(Cliente c: clienteOrdenAsc){
            System.out.println(c);
        }

        // editar
        System.out.println("============ Editar =================");
        Cliente beaUpdate = new Cliente("Bea", "Mena");
        beaUpdate.setId(2);
        repo.editar(beaUpdate);
        Cliente bea = repo.porId(2);
        System.out.println(bea);

        System.out.println("=============Eliminar===================");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("================= Total =================");
        System.out.println("Total => " + repo.total());


    }
}
