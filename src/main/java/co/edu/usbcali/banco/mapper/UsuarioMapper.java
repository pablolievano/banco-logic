package co.edu.usbcali.banco.mapper;

import java.util.List;

import co.edu.usbcali.banco.domain.Usuario;
import co.edu.usbcali.banco.dto.UsuarioDTO;

public interface UsuarioMapper {
	
	public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)throws Exception;

	public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)throws Exception;
	 
	public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> usuarios)throws Exception;

	public List<Usuario> listUsuarioDTOToListUsuario(List<UsuarioDTO> usuarioDTOs) throws Exception;
	
}
