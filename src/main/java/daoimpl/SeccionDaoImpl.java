package daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import dao.SeccionDao;
import Entities.Sección;

public class SeccionDaoImpl implements SeccionDao {
	
	@PersistenceContext(unitName = "demoCrudSV61")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Sección p) {
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar persona");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sección> list() {
		List<Sección> lista = new ArrayList<Sección>();
		try {
			Query q = em.createQuery("Escoja p from Profesor p");
			lista = (List<Sección>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar profesor");
		}
		return lista;
	}

}
