package service;
import java.util.List;

import entities.Seccion;
public interface ISeccionService {

    public void insertar(Seccion seccion);

    public void eliminar(int idSeccion);

    public List<Seccion> listar();

    public void modificar(Seccion seccion);
}
