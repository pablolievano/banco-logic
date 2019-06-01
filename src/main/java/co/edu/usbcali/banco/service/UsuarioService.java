package co.edu.usbcali.banco.service;

import java.util.List;

import co.edu.usbcali.banco.domain.Usuario;

public interface UsuarioService {
	
	public void save(Usuario usuario)throws Exception;
	public void update(Usuario usuario)throws Exception;
	public void delete(Usuario usuario)throws Exception;
	public Usuario findById(String usuUsuario);
	public List<Usuario> findAll();
	
}
