package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tareas;

    private Date inicioFechaTarea;

    private Date finFechaTarea;
    
    @Column(name = "entregableTarea", nullable = false, length = 60)
	private String entregableTarea;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarea(int id_tareas, Date inicioFechaTarea, Date finFechaTarea, String entregableTarea,
			Estudiante estudiante) {
		super();
		this.id_tareas = id_tareas;
		this.inicioFechaTarea = inicioFechaTarea;
		this.finFechaTarea = finFechaTarea;
		this.entregableTarea = entregableTarea;
		this.estudiante = estudiante;
	}

	public int getId_tareas() {
		return id_tareas;
	}

	public void setId_tareas(int id_tareas) {
		this.id_tareas = id_tareas;
	}

	public Date getInicioFechaTarea() {
		return inicioFechaTarea;
	}

	public void setInicioFechaTarea(Date inicioFechaTarea) {
		this.inicioFechaTarea = inicioFechaTarea;
	}

	public Date getFinFechaTarea() {
		return finFechaTarea;
	}

	public void setFinFechaTarea(Date finFechaTarea) {
		this.finFechaTarea = finFechaTarea;
	}

	public String getEntregableTarea() {
		return entregableTarea;
	}

	public void setEntregableTarea(String entregableTarea) {
		this.entregableTarea = entregableTarea;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

 
}

