package service;

import java.util.List;

import Entities.Profesores;

public interface ProfesoresService {

	public void insert(Profesores vc);

	List<Profesores> list();
}
