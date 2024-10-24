package pe.com.cibertec.EF_LP2.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.EF_LP2.model.entity.UsuarioEntity;

public interface UsuarioService {
	void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto);
	boolean validarUsuario(UsuarioEntity usuarioEntity);
	UsuarioEntity buscarUsuarioPorCorreo(String correo);
}
