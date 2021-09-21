package service;
import java.util.List;

import entities.Tarea;
public interface ITareaService {

    public void insertar(Tarea tarea);

    public void eliminar(int idEstudiante);

    public List<Tarea> listar();

    public void modificar(Tarea tarea);



}
