package co.edu.usbcali.banco.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.domain.TipoUsuario;
import co.edu.usbcali.banco.dto.TipoDocumentoDTO;
import co.edu.usbcali.banco.dto.TipoUsuarioDTO;

@Component
@Scope("singleton")
public class TipoUsuarioMapperImpl implements TipoUsuarioMapper {
	private static final Logger log = LoggerFactory.getLogger(TipoUsuarioMapperImpl.class);

	@Override
	@Transactional(readOnly = true)
	public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario) throws Exception {
		try {
			TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();

			tipoUsuarioDTO.setTiusId(tipoUsuario.getTiusId());
			tipoUsuarioDTO.setActivo((tipoUsuario.getActivo() != null)
                ? tipoUsuario.getActivo() : null);
			tipoUsuarioDTO.setNombre((tipoUsuario.getNombre() != null)
                ? tipoUsuario.getNombre() : null);

            return tipoUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public TipoUsuario tipoUsuarioDTOToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
		try {
			TipoUsuario tipoUsuario = new TipoUsuario();

			tipoUsuario.setTiusId(tipoUsuarioDTO.getTiusId());
			tipoUsuario.setActivo((tipoUsuarioDTO.getActivo() != null)
                ? tipoUsuarioDTO.getActivo() : null);
			tipoUsuario.setNombre((tipoUsuarioDTO.getNombre() != null)
                ? tipoUsuarioDTO.getNombre() : null);

            return tipoUsuario;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(List<TipoUsuario> listTipoUsuario) throws Exception {
		try {
            List<TipoUsuarioDTO> tipoUsuarioDTOs = new ArrayList<TipoUsuarioDTO>();

            for (TipoUsuario tipoUsuario : listTipoUsuario) {
            	TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioToTipoUsuarioDTO(tipoUsuario);

            	tipoUsuarioDTOs.add(tipoUsuarioDTO);
            }

            return tipoUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(List<TipoUsuarioDTO> listTipoUsuarioDTO)
			throws Exception {
		try {
            List<TipoUsuario> listTipoUsuario = new ArrayList<TipoUsuario>();

            for (TipoUsuarioDTO tipoUsuarioDTO : listTipoUsuarioDTO) {
            	TipoUsuario tipoUsuario = tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);

            	listTipoUsuario.add(tipoUsuario);
            }

            return listTipoUsuario;
        } catch (Exception e) {
            throw e;
        }
	}

}
