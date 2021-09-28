package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Entities.Sección;
import Entities.Profesores;
import service.SeccionService;
import service.ProfesoresService;

@Named
@RequestScoped
public class SeccionController {
	@Inject
	private SeccionService pService;
	@Inject
	private ProfesoresService vService;
//atributos
	private Sección seccion;
	private Profesores profesores;
	List<Sección> listaSeccion;
	List<Profesores> listaProfesores;

	// constructor
	@PostConstruct
	public void init() {
		this.seccion = new Sección();
		this.profesores = new Profesores();
		this.listaSeccion = new ArrayList<Sección>();
		this.listaProfesores = new ArrayList<Profesores>();
		this.listSeccion();
		this.listProfesores();
	}
//métodos personalizados

	public String newSeccion() {
		this.setSeccion(new Sección());
		this.listProfesores();
		return "person.xhtml";
	}

	public void listProfesores() {
		listaProfesores = vService.list();
	}

	public void insertSeccion() {
		pService.insert(seccion);
		this.listSeccion();
	}

	public void listSeccion() {
		listaSeccion = pService.list();
	}

//getters & setters
	public Sección getSección() {
		return seccion;
	}

	public void setSección(Sección seccion) {
		this.seccion = seccion;
	}

	public List<Sección> getListaSeccion() {
		return listaSeccion;
	}

	public void setListaSeccion(List<Sección> listaSeccion) {
		this.listaSeccion = listaSeccion;
	}

	public List<Profesores> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesores> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public Profesores getProfesores() {
		return profesores;
	}

	public void setProfesores(Profesores profesores) {
		this.profesores = profesores;
	}

}
