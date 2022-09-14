package org.afrivera.poointerfaces.repositorio;

import org.afrivera.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);


}
