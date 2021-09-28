package dao;

import java.util.List;

import Entities.Profesores;

public interface ProfesoresDao {
	public void insert(Profesores vc);

	public List<Profesores> list();
}
