
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Estudiante;
import entities.Tarea;
import service.IEstudianteService;
import service.ITareaService;

@Named
@RequestScoped
public class TareaController {
	@Inject
	private ITareaService tService;
	@Inject
	private IEstudianteService eService;
	//atributos
	private Tarea tarea;
	private Estudiante estudiante;
	List<Tarea> listaTareas;
	List<Estudiante> listaEstudiantes;

	//Constructor
	@PostConstruct	
	public void init() {
		this.tarea = new Tarea();
		this.estudiante = new Estudiante();
		this.listaTareas = new ArrayList<Tarea>();
		this.listaEstudiantes = new ArrayList<Estudiante>();
		this.listTarea();
		this.listEstudiante();
	}	
	// métodos personalizados
	
	public String newTarea() {
		this.setTarea(new Tarea());
		this.listEstudiante();
		return "tarea.xhtml";
	}
	
	public void listEstudiante() {
		listaEstudiantes = eService.listar();
	}
	public void insertTarea() {
		tService.insertar(tarea);
		this.listTarea();
		
	}
	
	public void eliminar(Tarea tarea) {
		tService.eliminar(tarea.getId_tareas());
		listTarea();
	}
	public void listTarea() {
		listaTareas = tService.listar();
	}
	
	public void modificar() {
		tService.modificar(this.tarea);
	}
	
	public String 	Modiftare(Tarea tarea) {
		this.setTarea(tarea);
		return "tareaMod.xhtml";
	}
	//getters y setters
	
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public List<Tarea> getListaTareas() {
		return listaTareas;
	}
	
	public void setListaTareas(List<Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public List<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}
	
	public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
}
