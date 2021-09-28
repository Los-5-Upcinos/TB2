package daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import dao.IEstudianteDao;
import entities.Estudiante;

public class IEstudianteDaoImpl implements IEstudianteDao {
	
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insertar(Estudiante estudiante) {
        try
        {
            entityManager.persist(estudiante);
        }catch (Exception e)
        {
            System.out.println("No se puede insertar");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<Estudiante>();
        try {        	
            Query q = entityManager.createQuery("select e from Estudiante e");
            lista = (List<Estudiante>) q.getResultList();

        } catch (Exception e) {
            
        }
        return lista;

    }
    
    @Transactional
    @Override
    public void eliminar(int id_estudiante) {
    	Estudiante estu= new Estudiante();
        try
        {
            estu=entityManager.getReference(Estudiante.class, id_estudiante);
            entityManager.remove(estu);
        }catch (Exception e)
        {
            System.out.println("No se puede eliminar");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> findByNameEstudiante(Estudiante estudiante) {
        List<Estudiante> lista = new ArrayList<Estudiante>();
        try {        	
            Query q = entityManager.createQuery("from Estudiante e where e.nameEstudiante like ?1 ");
            q.setParameter(1,"%"+ estudiante.getNameEstudiante()+ "%");
            lista = (List<Estudiante>) q.getResultList();

        } catch (Exception e) {
            
        }
        return lista;

    }

   

  
}
