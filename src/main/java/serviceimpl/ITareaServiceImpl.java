package serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.ITareaDao;
import entities.Tarea;
import service.ITareaService;

@Named
@RequestScoped
public class ITareaServiceImpl implements ITareaService {
	
	@Inject
	private ITareaDao tDao;
	
    @Override
    public void insertar(Tarea tarea) {
    	tDao.insertar(tarea);
    }

    @Override
    public void eliminar(int id_tareas) {
    	tDao.eliminar(id_tareas);
    }
    
    @Override
    public List<Tarea> listar() {
        return tDao.listar();
    }

  
    public void modificar(Tarea tarea) {
    	tDao.modificar(tarea);
    }
}
