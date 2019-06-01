package co.edu.usbcali.banco.service;

import java.util.List;

import co.edu.usbcali.banco.domain.TipoUsuario;

public interface TipoUsuarioService {
	
	public void save(TipoUsuario tipoUsuario)throws Exception;
	public void update(TipoUsuario tipoUsuario)throws Exception;
	public void delete(TipoUsuario tipoUsuario)throws Exception;
	public TipoUsuario findById(Long id);
	public List<TipoUsuario> findAll();	
	
}
