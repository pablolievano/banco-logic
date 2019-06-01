package co.edu.usbcali.banco.mapper;

import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.dto.TipoDocumentoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoDocumentoMapper {
    public TipoDocumentoDTO tipoDocumentoToTipoDocumentoDTO(
        TipoDocumento tipoDocumento) throws Exception;

    public TipoDocumento tipoDocumentoDTOToTipoDocumento(
        TipoDocumentoDTO tipoDocumentoDTO) throws Exception;

    public List<TipoDocumentoDTO> listTipoDocumentoToListTipoDocumentoDTO(
        List<TipoDocumento> tipoDocumentos) throws Exception;

    public List<TipoDocumento> listTipoDocumentoDTOToListTipoDocumento(
        List<TipoDocumentoDTO> tipoDocumentoDTOs) throws Exception;
}
