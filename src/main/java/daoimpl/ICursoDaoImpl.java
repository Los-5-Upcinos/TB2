package daoimpl;

import dao.ICursoDao;
import entities.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.transaction.Transactional;

public class ICursoDaoImpl implements ICursoDao {

    static Logger logger = Logger.getLogger(ICursoDaoImpl.class.getName());

    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Transactional
    @Override
    public boolean insertar(Curso curso) {
        try {
            entityManager.persist(curso);
            return true;
        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not insert Curso due to:");
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<>();
        try {
            Query q;
            q = entityManager.createQuery("select e from Curso e");
            lista = q.getResultList();

        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not list Curso due to:");
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
        return lista;
    }

    @Transactional
    @Override
    public void eliminar(int idCurso) {
        Curso c = new Curso();
        try {
            c = entityManager.getReference(Curso.class, idCurso);
            entityManager.remove(c);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not delete Curso due to:", e.getCause());
        }
    }

    @Transactional
    @Override
    public boolean modificar(Curso curso) {
        try {

            entityManager.merge(curso);
            return true;
        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not update Curso due to:", e.getCause());
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
            return false;
        }
    }

    @Override
    public Curso detalle(int idCurso) {
        try {
            return entityManager.find(Curso.class, idCurso);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not list Curso due to:", e.getCause());
            return null;
        }
    }
}
