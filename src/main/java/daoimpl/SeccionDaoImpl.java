package daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import dao.SeccionDao;
import Entities.Secci�n;

public class SeccionDaoImpl implements SeccionDao {
	
	@PersistenceContext(unitName = "demoCrudSV61")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Secci�n p) {
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar persona");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Secci�n> list() {
		List<Secci�n> lista = new ArrayList<Secci�n>();
		try {
			Query q = em.createQuery("Escoja p from Profesor p");
			lista = (List<Secci�n>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar profesor");
		}
		return lista;
	}

}
