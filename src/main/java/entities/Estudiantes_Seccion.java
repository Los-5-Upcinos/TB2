package pe.edu.upc.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Estudiante_Seccion")
public class Estudiante_Seccion {

	@ManyToOne
	@JoinColumn(name = "id_seccion", nullable = false)
	private Seccion seccion;
	
	@ManyToOne
	@JoinColumn(name = "id_estudiante", nullable = false)
	private Estudiante estudiante;

	public Estudiante_Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estudiante_Seccion(Seccion seccion, Estudiante estudiante) {
		super();
		this.seccion = seccion;
		this.estudiante = estudiante;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
}
