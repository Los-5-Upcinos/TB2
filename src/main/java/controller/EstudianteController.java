package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Estudiante;
import service.IEstudianteService;



@Named
@RequestScoped
public class EstudianteController {
	@Inject
	private  IEstudianteService eService;
	// atributos
	private Estudiante estudiante;
	List<Estudiante> listaEstudiante;
	
	@PostConstruct /**/
	public void init() {
		estudiante = new Estudiante();
		listaEstudiante = new ArrayList<Estudiante>();
		listar();

	}
	
	//metodos

	public String newEstudiante() {
		this.setEstudiante(new Estudiante());
		return "estudiante.xhtml";
	}
	
	public void insertar() {
		
		eService.insertar(estudiante);
		this.listar();
	}
	
	public void eliminar(Estudiante estudiante) {
		
		eService.eliminar(estudiante.getId_estudiante());
		listar();
	}
	
	public void listar() {
		listaEstudiante= eService.listar();
	}
	
	public void clean() {
		this.init();
	}
	
	public void findByName() {
		try {
			if(estudiante.getNameEstudiante().isEmpty()) {
				this.listar();
			}else {
				listaEstudiante = this.eService.findByNameEstudiante(this.getEstudiante());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 //getters y setters
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<Estudiante> getListaEstudiante() {
		return listaEstudiante;
	}

	public void setListaEstudiante(List<Estudiante> listaEstudiante) {
		this.listaEstudiante = listaEstudiante;
	}

	
	
}
