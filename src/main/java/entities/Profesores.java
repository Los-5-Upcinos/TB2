package Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Profesores")
public class Profesores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocente;
	private int Usuario_id_usuario;

	public Profesores() {
		super();
		// TODO
	}

	public Profesores(int idDocente, int Usuario_id_usuario) {
		super();
		this.idDocente = idDocente;
		this.Usuario_id_usuario = Usuario_id_usuario;
	}

	public int getidDocente() {
		return idDocente;
	}

	public void setidDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public int getUsuario_id_usuario() {
		return Usuario_id_usuario;
	}

	public void setUsuario_id_usuario(int Usuario_id_usuario) {
		this.Usuario_id_usuario = Usuario_id_usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDocente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesores other = (Profesores) obj;
		if (idDocente != other.idDocente)
			return false;
		return true;
	}

}
