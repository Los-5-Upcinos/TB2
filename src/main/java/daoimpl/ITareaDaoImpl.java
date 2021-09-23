package daoimpl;

import dao.IEstudianteDao;
import dao.ITareaDao;
import entities.Curso;
import entities.Tarea;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ITareaDaoImpl implements ITareaDao {
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Override
    public void insertar(Tarea tarea) {
        try
        {
            entityManager.persist(tarea);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("No se puede listar");
        }

    }

    @Override
    public List<Tarea> listar() {
        List<Tarea> lista = new ArrayList<Tarea>();
        try {
            Query q;
            q = entityManager.createQuery("select Tarea from Tarea m");
            lista = (List<Tarea>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public void eliminar(int idTarea) {
        Tarea tarea = new Tarea();
        try {
            tarea = entityManager.getReference(Tarea.class, idTarea);
            entityManager.remove(tarea);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void modificar(Tarea Tarea) {
        try {
            entityManager.merge(Tarea);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
