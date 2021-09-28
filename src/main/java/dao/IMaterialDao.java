package dao;
import entities.Material;

import java.util.List;
public interface IMaterialDao {

    public boolean insertar(Material material);

    public List<Material> listar();

    public void eliminar(int idMaterial);

    public void modificar(Material material);


}
