package service;
import java.util.List;

import entities.Tarea;
import entities.Usuario;
public interface IUsuarioService {

    public void insertar(Usuario usuario);

    public void eliminar(int idUsuario);

    public List<Usuario> listar();

    public void modificar(Usuario usuario);
}
