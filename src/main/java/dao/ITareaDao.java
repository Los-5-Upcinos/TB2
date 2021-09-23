package dao;
import entities.*;
import java.util.List;
public interface ITareaDao {
    public void insertar(Tarea tarea);

    public List<Tarea> listar();

    public void eliminar(int idTarea);

    public void modificar(Tarea tarea);
}
