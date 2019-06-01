package co.edu.usbcali.banco.mapper;

import java.util.List;

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.dto.ClienteDTO;

public interface ClienteMapper {
	
	 public ClienteDTO clienteToClienteDTO(Cliente cliente)throws Exception;

	 public Cliente clienteDTOToCliente(ClienteDTO clienteDTO)throws Exception;
	 
	 public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> clientes)throws Exception;

	 public List<Cliente> listClienteDTOToListCliente(List<ClienteDTO> clienteDTOs) throws Exception;

}
