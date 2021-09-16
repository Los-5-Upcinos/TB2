package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Estudiante")
public class estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estudiante;
	
	@ManyToOne
	@JoinColumn(name = "Id_Usuario", nullable = false)
	private Usuario id_Usuario;

	public estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public estudiante(int id_estudiante, Usuario id_Usuario) {
		super();
		this.id_estudiante = id_estudiante;
		this.id_Usuario = id_Usuario;
	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public Usuario getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Usuario id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	
	
}
