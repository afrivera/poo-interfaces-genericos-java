package org.afrivera.generics;

import org.afrivera.poointerfaces.modelo.Cliente;
import org.afrivera.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes= new ArrayList<>();
        clientes.add(new Cliente("Andres", "Rivera"));

        Cliente andres = clientes.iterator().next(); // clientes.get(0);

        Cliente[] clientesArreglo = { new Cliente("Andres", "Rivera"),
                new Cliente("Felipe", "Muelas")};
        Integer[] enterosArreglo = {1,2,3};

        List<Cliente> clientes1 = fromArrayToList(clientesArreglo);
        List<Integer> enteros1 = fromArrayToList(enterosArreglo);

        clientes1.forEach(System.out::println);
        enteros1.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[] {"Andres", "Pepe", "Lucy", "Bea"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiums = fromArrayToList(
                new ClientePremium[]{new ClientePremium("paco", "Fernandez")});

        imprimirClientes(clientes);
        imprimirClientes(clientes1);
        imprimirClientes(clientePremiums);

        System.out.println("=".repeat(40));
        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6 y 7.78 es: " + maximo(3.9, 11.6 , 7.78));
        System.out.println("Maximo de zanahoria, arandanos y manzana es: " + maximo("zanahoria", "arandanos" , "manzana"));
    }

    // metodo para pasar de enteros a arreglos
    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] g){
        for(G elemento: g){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) >0){
            max = b;
        }
        if(c.compareTo(max) >0){
            max = c;
        }
        return max;
    }
}
