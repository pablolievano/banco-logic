package co.edu.usbcali.banco.service;

import java.util.List;

import co.edu.usbcali.banco.domain.Cliente;

public interface ClienteService {
	
	public void save(Cliente cliente)throws Exception;
	public void update(Cliente cliente)throws Exception;
	public void delete(Cliente cliente)throws Exception;
	public Cliente findById(Long id);
	public List<Cliente> findAll();
	
}
