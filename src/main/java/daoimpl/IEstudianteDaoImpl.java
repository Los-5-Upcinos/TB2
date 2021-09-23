package daoimpl;

import dao.IEstudianteDao;
import entities.Curso;
import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class IEstudianteDaoImpl implements IEstudianteDao {
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Override
    public void insertar(Estudiante estudiante) {
        try
        {
            entityManager.persist(estudiante);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("No se puede listar");
        }

    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<Estudiante>();
        try {
            Query q;
            q = entityManager.createQuery("select Estudiante from Estudiante e");
            lista = (List<Estudiante>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public void eliminar(int idEstudiante) {
        Estudiante e = new Estudiante();
        try {
            e = entityManager.getReference(Estudiante.class, idEstudiante);
            entityManager.remove(e);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void modificar(Estudiante estudiante) {
        try {
            entityManager.merge(estudiante);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
