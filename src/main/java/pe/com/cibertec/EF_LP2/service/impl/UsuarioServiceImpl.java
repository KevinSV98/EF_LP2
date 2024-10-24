package pe.com.cibertec.EF_LP2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.EF_LP2.model.entity.UsuarioEntity;
import pe.com.cibertec.EF_LP2.repository.UsuarioRepository;
import pe.com.cibertec.EF_LP2.service.UsuarioService;
import pe.com.cibertec.EF_LP2.utils.Utilitarios;
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	private final UsuarioRepository usuarioRepository;


	@Override
	public void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto) {
		//1. Guardar la foto
		String nombreFoto = Utilitarios.guardarImagen(foto);
		usuarioEntity.setUrlImagen(nombreFoto);
		
		//2. Extraer el hash del password
		String passwordHash = Utilitarios.extraerHash(usuarioEntity.getPassword());
		usuarioEntity.setPassword(passwordHash);
		
		//3. guardar en la base de datos
		usuarioRepository.save(usuarioEntity);
		
	}

	@Override
	public boolean validarUsuario(UsuarioEntity usuarioFormulario) {
		//1. Buscar correo en base de datos
			UsuarioEntity usuarioEncontrado = usuarioRepository
					.findByCorreo(usuarioFormulario.getCorreo());
		
		// 2. Correo existe
			if(usuarioEncontrado == null) {
				return false;
			}
		// 3. Validar si el password del formulario hace match con el hash de la base de datos
			if(!Utilitarios.checkPassword(usuarioFormulario.getPassword(),
					usuarioEncontrado.getPassword())) {
				return false;
			}

		return true;
	}

	@Override
	public UsuarioEntity buscarUsuarioPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByCorreo(correo);
	}


}