package daoimpl;

import dao.ICursoDao;
import entities.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.transaction.Transactional;

public class ICursoDaoImpl implements ICursoDao {
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insertar(Curso curso) {
        try
        {
            entityManager.persist(curso);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("No se puede listar");
        }

    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<Curso>();
        try {
            Query q;
            q = entityManager.createQuery("select Curso from Curso s");
            lista = (List<Curso>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public void eliminar(int idCurso) {
        Curso c = new Curso();
        try {
            c = entityManager.getReference(Curso.class, idCurso);
            entityManager.remove(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void modificar(Curso curso) {
        try {
            entityManager.merge(curso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
