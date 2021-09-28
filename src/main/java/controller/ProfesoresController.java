package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Entities.Profesores;
import service.ProfesoresService;

@Named
@RequestScoped
public class ProfesoresController {
	@Inject
	private ProfesoresService vService;
	// atributos
	private Profesores profesores;
	List<Profesores> listaProfesores;

	@PostConstruct /**/
	public void init() {
		profesores = new Profesores();
		listaProfesores = new ArrayList<Profesores>();
		list();

	}

	// mètodos

	public String newVaccination() {
		this.setProfesores(new Profesores());
		return "vaccination.xhtml";

	}

	public void insert() {
		vService.insert(profesores);
		list();
	}

	public void list() {
		listaProfesores = vService.list();
	}

	// getters & setters
	public Profesores getProfesores() {
		return profesores;
	}

	public void setProfesores(Profesores profesores) {
		this.profesores = profesores;
	}

	public List<Profesores> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaVacunatorios(List<Profesores> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

}
