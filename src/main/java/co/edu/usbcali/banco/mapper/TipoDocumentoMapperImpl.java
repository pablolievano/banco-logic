package co.edu.usbcali.banco.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.dto.TipoDocumentoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class TipoDocumentoMapperImpl implements TipoDocumentoMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoMapperImpl.class);

    @Transactional(readOnly = true)
    public TipoDocumentoDTO tipoDocumentoToTipoDocumentoDTO(
        TipoDocumento tipoDocumento) throws Exception {
        try {
            TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();

            tipoDocumentoDTO.setTdocId(tipoDocumento.getTdocId());
            tipoDocumentoDTO.setActivo((tipoDocumento.getActivo() != null)
                ? tipoDocumento.getActivo() : null);
            tipoDocumentoDTO.setNombre((tipoDocumento.getNombre() != null)
                ? tipoDocumento.getNombre() : null);

            return tipoDocumentoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoDocumento tipoDocumentoDTOToTipoDocumento(
        TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = new TipoDocumento();

            tipoDocumento.setTdocId(tipoDocumentoDTO.getTdocId());
            tipoDocumento.setActivo((tipoDocumentoDTO.getActivo() != null)
                ? tipoDocumentoDTO.getActivo() : null);
            tipoDocumento.setNombre((tipoDocumentoDTO.getNombre() != null)
                ? tipoDocumentoDTO.getNombre() : null);

            return tipoDocumento;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoDocumentoDTO> listTipoDocumentoToListTipoDocumentoDTO(
        List<TipoDocumento> listTipoDocumento) throws Exception {
        try {
            List<TipoDocumentoDTO> tipoDocumentoDTOs = new ArrayList<TipoDocumentoDTO>();

            for (TipoDocumento tipoDocumento : listTipoDocumento) {
                TipoDocumentoDTO tipoDocumentoDTO = tipoDocumentoToTipoDocumentoDTO(tipoDocumento);

                tipoDocumentoDTOs.add(tipoDocumentoDTO);
            }

            return tipoDocumentoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoDocumento> listTipoDocumentoDTOToListTipoDocumento(
        List<TipoDocumentoDTO> listTipoDocumentoDTO) throws Exception {
        try {
            List<TipoDocumento> listTipoDocumento = new ArrayList<TipoDocumento>();

            for (TipoDocumentoDTO tipoDocumentoDTO : listTipoDocumentoDTO) {
                TipoDocumento tipoDocumento = tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

                listTipoDocumento.add(tipoDocumento);
            }

            return listTipoDocumento;
        } catch (Exception e) {
            throw e;
        }
    }
}
