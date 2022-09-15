package org.afrivera.poointerfaces.repositorio.list;

import org.afrivera.poointerfaces.modelo.Cliente;
import org.afrivera.poointerfaces.repositorio.AbstractaListRepositorio;
import org.afrivera.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort(( a,  b) ->{
                int resultado = 0;
                if(dir==Direccion.ASC){
                    resultado = ordenar(a, b, campo);
                }else if(dir == Direccion.DESC){
                    resultado = ordenar(b, a, campo);
                }
                return resultado;
            }


        );
        return listaOrdenada;
    }

    public static int ordenar(Cliente a, Cliente b, String campo){
        int resultado = 0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

}
