package dao;

import entities.Estudiante;

import java.util.List;

public interface IEstudianteDao {
    public void insertar(Estudiante estudiante);

    public List<Estudiante> listar();
    
    public void eliminar (int id_estudiante);
    
    public List<Estudiante> findByNameEstudiante(Estudiante estudiante);

  

}
