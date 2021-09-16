package entities;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tareas_Seccion")
public class Tareas_Seccion {

	@ManyToOne
	@JoinColumn(name = "id_tareas", nullable = false)
	private Tareas tareas;

	@ManyToOne
	@JoinColumn(name = "id_seccion", nullable = false)
	private Seccion seccion;

	public Tareas_Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tareas_Seccion(Tareas tareas, Seccion seccion) {
		super();
		this.tareas = tareas;
		this.seccion = seccion;
	}

	public Tareas getTareas() {
		return tareas;
	}

	public void setTareas(Tareas tareas) {
		this.tareas = tareas;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	
}
