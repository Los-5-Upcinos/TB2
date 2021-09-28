package serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.SeccionDao;
import Entities.Seccion;
import service.SeccionService;

@Named
@RequestScoped
public class SeccionImpl implements SeccionService {
	@Inject
	private SeccionDao pDao;

	@Override
	public void insert(Seccion p) {
		pDao.insert(p);
	}

	@Override
	public List<Seccion> list() {

		return pDao.list();
	}

}
