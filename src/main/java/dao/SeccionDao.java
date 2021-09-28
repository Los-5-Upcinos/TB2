package dao;

import java.util.List;

import Entities.Sección;

public interface SeccionDao {

	public void insert(Sección p);

	public List<Sección> list();
}
