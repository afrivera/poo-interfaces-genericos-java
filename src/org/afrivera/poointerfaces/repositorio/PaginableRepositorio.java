package org.afrivera.poointerfaces.repositorio;

import org.afrivera.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
