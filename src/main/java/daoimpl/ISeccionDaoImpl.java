package daoimpl;

import dao.IEstudianteDao;
import dao.ISeccionDao;
import entities.Curso;
import entities.Seccion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ISeccionDaoImpl implements ISeccionDao {
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Override
    public void insertar(Seccion seccion) {
        try
        {
            entityManager.persist(seccion);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("No se puede listar");
        }

    }

    @Override
    public List<Seccion> listar() {
        List<Seccion> lista = new ArrayList<Seccion>();
        try {
            Query q;
            q = entityManager.createQuery("select Seccion from Seccion m");
            lista = (List<Seccion>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public void eliminar(int idSeccion) {
        Seccion seccion = new Seccion();
        try {
            seccion = entityManager.getReference(Seccion.class, idSeccion);
            entityManager.remove(seccion);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void modificar(Seccion Seccion) {
        try {
            entityManager.merge(Seccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
