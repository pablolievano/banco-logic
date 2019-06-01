package co.edu.usbcali.banco.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.domain.TipoUsuario;
import co.edu.usbcali.banco.domain.Usuario;
import co.edu.usbcali.banco.dto.ClienteDTO;
import co.edu.usbcali.banco.dto.UsuarioDTO;
import co.edu.usbcali.banco.service.TipoUsuarioService;

@Component
@Scope("singleton")
public class UsuarioMapperImpl implements UsuarioMapper {
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;

	@Override
	@Transactional(readOnly = true)
	public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) throws Exception {
		try {
			UsuarioDTO usuarioDTO = new UsuarioDTO();

			usuarioDTO.setUsuUsuario(usuario.getUsuUsuario());
			usuarioDTO.setActivo((usuario.getActivo() != null)
                ? usuario.getActivo() : null);
			usuarioDTO.setClave((usuario.getClave() != null)
                ? usuario.getClave() : null);
			usuarioDTO.setIdentificacion((usuario.getIdentificacion() != null)
                ? usuario.getIdentificacion() : null);
			usuarioDTO.setNombre((usuario.getNombre() != null)
                ? usuario.getNombre() : null);
			usuarioDTO.setTiusId((usuario.getTipoUsuario().getTiusId() != null)
                ? usuario.getTipoUsuario().getTiusId() : null);

            return usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) throws Exception {
		try {
            Usuario usuario = new Usuario();

            usuario.setUsuUsuario(usuarioDTO.getUsuUsuario());
            usuario.setActivo((usuarioDTO.getActivo() != null)
                ? usuarioDTO.getActivo() : null);
            usuario.setClave((usuarioDTO.getClave() != null)
                ? usuarioDTO.getClave() : null);
            usuario.setIdentificacion((usuarioDTO.getIdentificacion() != null)
                ? usuarioDTO.getIdentificacion() : null);
            usuario.setNombre((usuarioDTO.getNombre() != null)
                ? usuarioDTO.getNombre() : null);

            TipoUsuario tipoUsuario = new TipoUsuario();

            if (usuarioDTO.getTiusId() != null) {
            	tipoUsuario = tipoUsuarioService.findById(usuarioDTO.getTiusId());
            }

            if (tipoUsuario != null) {
            	usuario.setTipoUsuario(tipoUsuario);
            }

            return usuario;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> listUsuario) throws Exception {
		try {
            List<UsuarioDTO> UsuarioDTOs = new ArrayList<UsuarioDTO>();

            for (Usuario usuario : listUsuario) {
            	UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);

            	UsuarioDTOs.add(usuarioDTO);
            }

            return UsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listUsuarioDTOToListUsuario(List<UsuarioDTO> listUsuarioDTO) throws Exception {
		try {
            List<Usuario> listUsuario = new ArrayList<Usuario>();

            for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
                Usuario usuario = usuarioDTOToUsuario(usuarioDTO);

                listUsuario.add(usuario);
            }

            return listUsuario;
        } catch (Exception e) {
            throw e;
        }
	}

}
