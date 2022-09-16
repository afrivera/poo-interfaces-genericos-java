package org.afrivera.poointerfaces;

import org.afrivera.poointerfaces.modelo.Cliente;
import org.afrivera.poointerfaces.repositorio.*;
import org.afrivera.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.afrivera.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import org.afrivera.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.afrivera.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import org.afrivera.poointerfaces.repositorio.list.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Perez"));
            repo.crear(new Cliente("Bea", "Gonzalez"));
            repo.crear(new Cliente("Luci", "Martinez"));
            Cliente andres = new Cliente("Andres", "Rivera");
            repo.crear(andres);
            // manejar error de un id o object duplicado
            // repo.crear(andres);

            // error para crear
            //repo.crear(null);

            List<Cliente> clientes = repo.listar();
            // clientes.forEach(cliente -> System.out.println(cliente)); se puede resumir
            clientes.forEach(System.out::println);
            System.out.println("=".repeat(40));
            List<Cliente> paginable = repo.listar(1, 3);// indice 1 y indice 2 excluye el 3
            paginable.forEach(System.out::println);
            System.out.println("=".repeat(40));
            List<Cliente> clienteOrdenAsc = repo.listar("nombre", Direccion.ASC);

            for (Cliente c : clienteOrdenAsc) {
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
        }catch (LecturaAccesoDatoException lae){ // siempre van primero las hijas y despues el padre
            System.out.println("Lectura: " + lae.getMessage());
            lae.printStackTrace();
        } catch(RegistroDuplicadoAccesoDatoException rda){
            System.out.println("Duplicado: " + rda.getMessage());
            rda.printStackTrace();
        } catch (EscrituraAccesoDatosException ead){
            System.out.println("Escritura =>" + ead.getMessage());
            ead.printStackTrace();
        } catch (AccesoDatoException e){
            System.out.println("Generica: => " + e.getMessage());
            e.printStackTrace();
        }

    }
}
