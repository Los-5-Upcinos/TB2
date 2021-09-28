package serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.ProfesoresDao;
import Entities.Profesores;
import service.ProfesoresService;

@Named
@RequestScoped
public class ProfesoresServiceImpl implements ProfesoresService {
	@Inject
	private ProfesoresDao vDao;

	@Override
	public void insert(Profesores vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);
	}

	@Override
	public List<Profesores> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}

}
