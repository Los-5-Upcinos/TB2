package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Entities.Secci�n;
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
	private Secci�n seccion;
	private Profesores profesores;
	List<Secci�n> listaSeccion;
	List<Profesores> listaProfesores;

	// constructor
	@PostConstruct
	public void init() {
		this.seccion = new Secci�n();
		this.profesores = new Profesores();
		this.listaSeccion = new ArrayList<Secci�n>();
		this.listaProfesores = new ArrayList<Profesores>();
		this.listSeccion();
		this.listProfesores();
	}
//m�todos personalizados

	public String newSeccion() {
		this.setSeccion(new Secci�n());
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
	public Secci�n getSecci�n() {
		return seccion;
	}

	public void setSecci�n(Secci�n seccion) {
		this.seccion = seccion;
	}

	public List<Secci�n> getListaSeccion() {
		return listaSeccion;
	}

	public void setListaSeccion(List<Secci�n> listaSeccion) {
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
