package service;
import java.util.List;

import entities.Profesor;
public interface IProfesorService {
    public void insertar(Profesor profesor);

    public void eliminar(int idProfesor);

    public List<Profesor> listar();

    public void modificar(Profesor profesor);



}
