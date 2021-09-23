package serviceimpl;

import entities.Curso;
import service.ICursoService;
import javax.inject.*;

import dao.ICursoDao;

import java.util.List;

public class ICursoServiceImpl implements ICursoService {

    @Inject
    private ICursoDao cDao;

    @Override
    public void insertar(Curso curso) {
        cDao.insertar(curso);
    }

    @Override
    public void eliminar(int idCurso) {
        cDao.eliminar(idCurso);
    }

    @Override
    public List<Curso> listar() {
        return cDao.listar();
    }

    @Override
    public void modificar(Curso curso) {
        cDao.modificar(curso);
    }

}
