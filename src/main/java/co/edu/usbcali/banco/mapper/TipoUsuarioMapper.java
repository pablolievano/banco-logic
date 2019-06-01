package co.edu.usbcali.banco.mapper;

import java.util.List;

import co.edu.usbcali.banco.domain.TipoUsuario;
import co.edu.usbcali.banco.dto.TipoUsuarioDTO;

public interface TipoUsuarioMapper {
	
	public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario) throws Exception;

	public TipoUsuario tipoUsuarioDTOToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) throws Exception;

	public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(List<TipoUsuario> tipoUsuarios) throws Exception;

    public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(List<TipoUsuarioDTO> tipoUsuarioDTOs) throws Exception;
	
}
