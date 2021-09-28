package daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import dao.ProfesoresDao;
import Entities.Profesores;

public class ProfesoresDaoImpl implements ProfesoresDao {
	
	@PersistenceContext(unitName = "2021-2")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Profesores vc) {

		try {
			em.persist(vc);
		} catch (Exception e) {

			System.out.println("Error al insertar");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesores> list() {
		List<Profesores> lista = new ArrayList<Profesores>();
		try {

			Query q = em.createQuery("select v from VaccinationCenter v");
			lista = (List<Profesores>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

}
