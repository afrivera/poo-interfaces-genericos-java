package org.afrivera.poointerfaces.repositorio;


import org.afrivera.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listar();
    // en las interfaces siempre va el tipo más generico
    T porId(Integer id) throws AccesoDatoException;
    void crear(T t) throws AccesoDatoException;
    void editar(T t) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;
}
