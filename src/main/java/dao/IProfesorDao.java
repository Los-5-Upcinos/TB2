package dao;
import entities.*;
import java.util.List;
public interface IProfesorDao {
    public void insertar(Profesor profesor);

    public List<Profesor> listar();

    public void eliminar(int idProfesor);

    public void modificar(Profesor profesor);



}
