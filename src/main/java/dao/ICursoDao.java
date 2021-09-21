package dao;
import java.util.List;
import entities.Curso;

public interface ICursoDao {

    public void insertar(Curso curso);

    public List<Curso> listar();

    public void eliminar(int idCurso);

    public void modificar(Curso curso);
}
