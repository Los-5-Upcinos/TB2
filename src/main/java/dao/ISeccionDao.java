package dao;
import entities.*;
import java.util.List;
public interface ISeccionDao {
    public void insertar(Seccion seccion);

    public List<Seccion> listar();

    public void eliminar(int idSeccion);

    public void modificar(Seccion seccion);
}
