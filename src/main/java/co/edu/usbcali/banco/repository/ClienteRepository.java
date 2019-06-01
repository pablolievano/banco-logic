package co.edu.usbcali.banco.repository;

import java.util.List;

import co.edu.usbcali.banco.domain.Cliente;

public interface ClienteRepository {
	
	public void save(Cliente cliente);
	public void update(Cliente cliente);
	public void delete(Cliente cliente);
	public Cliente findById(Long id);
	public List<Cliente> findAll();
}
