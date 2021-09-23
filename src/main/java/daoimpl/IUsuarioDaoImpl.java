package daoimpl;

import dao.IEstudianteDao;
import dao.IUsuarioDao;
import entities.Curso;
import entities.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class IUsuarioDaoImpl implements IUsuarioDao {
    @PersistenceContext(unitName = "TB2Web")
    private EntityManager entityManager;

    @Override
    public void insertar(Usuario usuario) {
        try
        {
            entityManager.persist(usuario);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("No se puede listar");
        }

    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            Query q;
            q = entityManager.createQuery("select Usuario from Usuario m");
            lista = (List<Usuario>) q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    @Override
    public void eliminar(int idUsuario) {
        Usuario usuario = new Usuario();
        try {
            usuario = entityManager.getReference(Usuario.class, idUsuario);
            entityManager.remove(usuario);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void modificar(Usuario Usuario) {
        try {
            entityManager.merge(Usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
