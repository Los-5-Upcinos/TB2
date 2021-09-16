package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tareas")
public class Tareas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tareas;
	

	@Column(name = "inicio_fecha", length = 45, nullable = false)
	private Date inicio_fecha;

	@Column(name = "fin_fecha", length = 45, nullable = false)
	private Date fin_fecha;
	
	@Column(name = "entregable", nullable = false, length = 150)
	private String entregable;

	public Tareas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tareas(int id_tareas, Date inicio_fecha, Date fin_fecha, String entregable) {
		super();
		this.id_tareas = id_tareas;
		this.inicio_fecha = inicio_fecha;
		this.fin_fecha = fin_fecha;
		this.entregable = entregable;
	}

	public int getId_tareas() {
		return id_tareas;
	}

	public void setId_tareas(int id_tareas) {
		this.id_tareas = id_tareas;
	}

	public Date getInicio_fecha() {
		return inicio_fecha;
	}

	public void setInicio_fecha(Date inicio_fecha) {
		this.inicio_fecha = inicio_fecha;
	}

	public Date getFin_fecha() {
		return fin_fecha;
	}

	public void setFin_fecha(Date fin_fecha) {
		this.fin_fecha = fin_fecha;
	}

	public String getEntregable() {
		return entregable;
	}

	public void setEntregable(String entregable) {
		this.entregable = entregable;
	}
	
	
	
}
