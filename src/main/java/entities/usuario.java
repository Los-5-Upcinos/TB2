package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Usuario;
	
	@Column(name = "nombre_usuario", nullable = false, length = 45)
	private String nombre_usuario;

	@Column(name = "contraseña_usuario", nullable = false, length = 45)
	private String contraseña_usuario;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id_Usuario, String nombre_usuario, String contraseña_usuario) {
		super();
		this.Id_Usuario = id_Usuario;
		this.nombre_usuario = nombre_usuario;
		this.contraseña_usuario = contraseña_usuario;
	}

	public int getId_Usuario() {
		return Id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		Id_Usuario = id_Usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContraseña_usuario() {
		return contraseña_usuario;
	}

	public void setContraseña_usuario(String contraseña_usuario) {
		this.contraseña_usuario = contraseña_usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id_Usuario;
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
		VaccinationCenter other = (VaccinationCenter) obj;
		if (Id_Usuario != other.Id_Usuario)
			return false;
		return true;
	}


	
	
	
	
}
