package service;
import java.util.List;
import entities.Estudiante;
public interface IEstudianteService {

    public void insertar(Estudiante estudiante);

    public void eliminar(int idEstudiante);

    public List<Estudiante> listar();

    public void modificar(Estudiante estudiante);


}
