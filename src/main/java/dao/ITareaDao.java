package dao;

import java.util.List;

import entities.Tarea;

public interface ITareaDao {
    public void insertar(Tarea tarea);

    public List<Tarea> listar();
    
    public void eliminar(int id_tareas);
    
    public void modificar(Tarea tarea);


}
