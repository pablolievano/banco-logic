package co.edu.usbcali.banco.service;

import java.util.List;

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;

public interface TipoDocumentoService {
	
	public void save(TipoDocumento tipoDocumento)throws Exception;
	public void update(TipoDocumento tipoDocumento)throws Exception;
	public void delete(TipoDocumento tipoDocumento)throws Exception;
	public TipoDocumento findById(Long id);
	public List<TipoDocumento> findAll();
	
}
