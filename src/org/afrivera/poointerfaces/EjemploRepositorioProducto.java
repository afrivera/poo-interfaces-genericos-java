package org.afrivera.poointerfaces;

import org.afrivera.poointerfaces.modelo.Cliente;
import org.afrivera.poointerfaces.modelo.Producto;
import org.afrivera.poointerfaces.repositorio.Direccion;
import org.afrivera.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.afrivera.poointerfaces.repositorio.list.ClienteListRepositorio;
import org.afrivera.poointerfaces.repositorio.list.ProductoListrepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListrepositorio();
        repo.crear(new Producto("Mesa", 50));
        repo.crear(new Producto("Silla", 18));
        repo.crear(new Producto("Lamapra", 15.5));
        repo.crear(new Producto("NoteBook", 400.0));

        List<Producto> productos =repo.listar();
        // productos.forEach(cliente -> System.out.println(cliente)); se puede resumir
        productos.forEach(System.out::println);
        System.out.println("=".repeat(40));
        List<Producto> paginable = repo.listar(1, 3);// indice 1 y indice 2 excluye el 3
        paginable.forEach(System.out::println);
        System.out.println("=".repeat(40));
        List<Producto> productoOrdenAsc = repo.listar("descripcion", Direccion.ASC);

        for(Producto c: productoOrdenAsc){
            System.out.println(c);
        }

        // editar
        System.out.println("============ Editar =================");
        Producto lamparaUpdate = new Producto("Lampara", 35.8);
        lamparaUpdate.setId(3);
        repo.editar(lamparaUpdate);
        Producto lampara = repo.porId(2);
        System.out.println(lampara);

        System.out.println("=============Eliminar===================");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("================= Total =================");
        System.out.println("Total => " + repo.total());


    }
}
