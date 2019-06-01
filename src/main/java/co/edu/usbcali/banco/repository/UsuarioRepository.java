package co.edu.usbcali.banco.repository;

import java.util.List;

import co.edu.usbcali.banco.domain.Usuario;

public interface UsuarioRepository {
	
	public void save(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Usuario findById(String usuUsuario);
	public List<Usuario> findAll();
}
