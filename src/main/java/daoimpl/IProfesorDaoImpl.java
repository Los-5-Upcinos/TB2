package daoimpl;

import dao.IEstudianteDao;
import dao.IProfesorDao;
import entities.Curso;
import entities.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class IProfesorDaoImpl implements IProfesorDao {
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Override
    public void insertar(Profesor profesor) {
        try
        {
            entityManager.persist(profesor);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("No se puede listar");
        }

    }

    @Override
    public List<Profesor> listar() {
        List<Profesor> lista = new ArrayList<Profesor>();
        try {
            Query q;
            q = entityManager.createQuery("select Profesor from Profesor m");
            lista = (List<Profesor>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public void eliminar(int idProfesor) {
        Profesor profesor = new Profesor();
        try {
            profesor = entityManager.getReference(Profesor.class, idProfesor);
            entityManager.remove(profesor);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void modificar(Profesor profesor) {
        try {
            entityManager.merge(profesor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
