package service;
import java.util.List;
import entities.Material;
public interface IMaterialService {
    public boolean insertar(Material material);

    public void eliminar(int idMaterial);

    public List<Material> listar();

    public void modificar(Material material);


}
