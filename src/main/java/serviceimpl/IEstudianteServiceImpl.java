package serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.IEstudianteDao;
import entities.Estudiante;
import service.IEstudianteService;

@Named
@RequestScoped
public class IEstudianteServiceImpl implements IEstudianteService {
	
	@Inject
	private IEstudianteDao eDao;
	
    @Override
    public void insertar(Estudiante estudiante) {
    	eDao.insertar(estudiante);
    }
    
    @Override
    public void eliminar(int id_estudiante) {
    	eDao.eliminar(id_estudiante);
    }

    @Override
    public List<Estudiante> listar() {
        return eDao.listar();
    }
    

    @Override
    public List<Estudiante> findByNameEstudiante(Estudiante estudiante) {
        return eDao.findByNameEstudiante(estudiante);
    }

}
