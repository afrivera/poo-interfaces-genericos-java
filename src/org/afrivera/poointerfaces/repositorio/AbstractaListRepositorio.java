package org.afrivera.poointerfaces.repositorio;

import org.afrivera.poointerfaces.modelo.BaseEntity;
import org.afrivera.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if(id == null || id<=0){
            throw new LecturaAccesoDatoException("Id Invalido debe ser mayor a 0");
        }
        T resultado = null;
        for(T cli: dataSource){
            if(cli.getId()!= null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        if(resultado== null){
            throw new LecturaAccesoDatoException("No existe el registro con el id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatosException {
        if(t==null){
            throw new EscrituraAccesoDatosException("Error al insertar un objeto null");
        }
        if(this.dataSource.contains(t)){
            throw  new RegistroDuplicadoAccesoDatoException("Error el objecto con id: " +
                    t.getId() + " ya existe en el repositorio");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        // Cliente c = this.porId(id);
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
