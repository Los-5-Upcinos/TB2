package daoimpl;

import dao.IEstudianteDao;
import dao.IMaterialDao;
import entities.Curso;
import entities.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class IMaterialDaoImpl implements IMaterialDao {
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Override
    public void insertar(Material material) {
        try
        {
            entityManager.persist(material);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("No se puede listar");
        }

    }

    @Override
    public List<Material> listar() {
        List<Material> lista = new ArrayList<Material>();
        try {
            Query q;
            q = entityManager.createQuery("select Material from Material m");
            lista = (List<Material>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public void eliminar(int idMaterial) {
        Material material = new Material();
        try {
            material = entityManager.getReference(Material.class, idMaterial);
            entityManager.remove(material);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void modificar(Material material) {
        try {
            entityManager.merge(material);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
