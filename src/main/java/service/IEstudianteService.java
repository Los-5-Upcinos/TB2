package service;
import java.util.List;
import entities.Estudiante;
public interface IEstudianteService {

    public void insertar(Estudiante estudiante);

    public void eliminar(int id_estudiante);
    List<Estudiante> listar();
    
    public List<Estudiante> findByNameEstudiante(Estudiante estudiante);


}
