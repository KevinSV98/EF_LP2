package pe.com.cibertec.EF_LP2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {


	@Id
	@Column(name = "correo", nullable = false, length = 60)
	private String correo;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@Column(name = "celular", nullable = false, 
			columnDefinition = "CHAR(9)", length = 9, unique = true)
	private String celular;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "url_imagen")
	private String urlImagen;
}