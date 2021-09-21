package service;

import java.util.List;
import entities.Curso;

public interface ICursoService {
    public void insertar(Curso curso);

    public void eliminar(int idCurso);

    public List<Curso> listar();

    public void modificar(Curso curso);


}
