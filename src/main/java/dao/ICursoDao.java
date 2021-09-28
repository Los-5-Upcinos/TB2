package dao;

import java.util.List;

import entities.Curso;

public interface ICursoDao {

    public boolean insertar(Curso curso);

    public List<Curso> listar();

    public void eliminar(int idCurso);

    public boolean modificar(Curso curso);

    public Curso detalle(int idCurso);
}
