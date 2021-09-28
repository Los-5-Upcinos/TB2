package daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import dao.ITareaDao;
import entities.Tarea;

public class ITareaDaoImpl implements ITareaDao {
	
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

	@Transactional
    @Override
    public void insertar(Tarea tarea) {
        try
        {
            entityManager.persist(tarea);
        }catch (Exception e)
        {
            System.out.println("No se puede insertar una tarea");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tarea> listar() {
        List<Tarea> lista = new ArrayList<Tarea>();
        try {
            Query q = entityManager.createQuery("select t from Tarea t");
            lista = (List<Tarea>) q.getResultList();
        } catch (Exception e) {
           
        }
        return lista;
    }

    @Transactional
    @Override
    public void eliminar(int id_tareas) {
    	Tarea tare= new Tarea();
        try
        {
            tare=entityManager.getReference(Tarea.class, id_tareas);
            entityManager.remove(tare);
        }catch (Exception e)
        {
            System.out.println("No se puede eliminar una tarea");
        }

    }
    
    
    @Transactional
    @Override
    public void modificar(Tarea tarea) {
        try
        {
            entityManager.merge(tarea);
        }catch (Exception e)
        {
            System.out.println("No se puede insertar una tarea");
        }

    }
  
}
