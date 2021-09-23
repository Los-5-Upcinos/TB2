package dao;
import entities.*;
import java.util.List;
public interface IUsuarioDao {
    public void insertar(Usuario usuario);

    public List<Usuario> listar();

    public void eliminar(int idUsuario);

    public void modificar(Usuario usuario);
}
