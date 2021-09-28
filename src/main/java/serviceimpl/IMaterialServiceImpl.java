package serviceimpl;

import dao.IMaterialDao;
import entities.Material;
import service.IMaterialService;

import javax.inject.Inject;
import java.util.List;

public class IMaterialServiceImpl implements IMaterialService {

    @Inject
    IMaterialDao materialDao;

    @Override
    public boolean insertar(Material material) {
        return materialDao.insertar(material);
    }

    @Override
    public void eliminar(int idMaterial) {
        materialDao.eliminar(idMaterial);
    }

    @Override
    public List<Material> listar() {
        return materialDao.listar();
    }

    @Override
    public void modificar(Material material) {
        materialDao.modificar(material);

    }
}
