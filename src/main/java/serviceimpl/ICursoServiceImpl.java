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
    public boolean insertar(Curso curso) {
        return cDao.insertar(curso);
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
    public boolean modificar(Curso curso) {
        return cDao.modificar(curso);
    }

    @Override
    public Curso detalle(int idCurso) {
        return cDao.detalle(idCurso);
    }

}
