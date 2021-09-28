package daoimpl;

import dao.IMaterialDao;
import entities.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IMaterialDaoImpl implements IMaterialDao {

    static Logger logger = Logger.getLogger(IMaterialDaoImpl.class.getName());

    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Transactional
    @Override
    public boolean insertar(Material material) {
        try {
            entityManager.persist(material);
            return true;
        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not insert Material due to:");
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
            return false;
        }
    }

    @Transactional
    @Override
    public List<Material> listar() {
        List<Material> lista = new ArrayList<>();
        try {
            Query q;
            q = entityManager.createQuery("select m from Material m");
            lista = (List<Material>) q.getResultList();

        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not list Material due to:", e.getCause());
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
        return lista;
    }

    @Transactional
    @Override
    public void eliminar(int idMaterial) {
        Material material = new Material();
        try {
            material = entityManager.getReference(Material.class, idMaterial);
            entityManager.remove(material);
        } catch (Exception exception) {
            logger.log(Level.WARNING, "Could not delete Material due to:", exception.getCause());
        }
    }

    @Transactional
    @Override
    public void modificar(Material material) {
        try {
            entityManager.merge(material);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not update Material due to:", e.getCause());
        }
    }
}
