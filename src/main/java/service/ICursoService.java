package service;

import java.util.List;
import entities.Curso;

public interface ICursoService {
    public boolean insertar(Curso curso);

    public void eliminar(int idCurso);

    public List<Curso> listar();

    public boolean modificar(Curso curso);

    public Curso detalle(int idCurso);
}
