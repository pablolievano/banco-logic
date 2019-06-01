package co.edu.usbcali.banco.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.domain.Cliente;
import co.edu.usbcali.banco.domain.TipoDocumento;
import co.edu.usbcali.banco.dto.ClienteDTO;
import co.edu.usbcali.banco.service.TipoDocumentoService;


@Component
@Scope("singleton")
public class ClienteMapperImpl implements ClienteMapper {
	
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	 @Transactional(readOnly = true)
	    public ClienteDTO clienteToClienteDTO(Cliente cliente)
	        throws Exception {
	        try {
	            ClienteDTO clienteDTO = new ClienteDTO();

	            clienteDTO.setClieId(cliente.getClieId());
	            clienteDTO.setActivo((cliente.getActivo() != null)
	                ? cliente.getActivo() : null);
	            clienteDTO.setDireccion((cliente.getDireccion() != null)
	                ? cliente.getDireccion() : null);
	            clienteDTO.setEmail((cliente.getEmail() != null)
	                ? cliente.getEmail() : null);
	            clienteDTO.setNombre((cliente.getNombre() != null)
	                ? cliente.getNombre() : null);
	            clienteDTO.setTelefono((cliente.getTelefono() != null)
	                ? cliente.getTelefono() : null);
	            clienteDTO.setTdocId((cliente.getTipoDocumento()
	                                                       .getTdocId() != null)
	                ? cliente.getTipoDocumento().getTdocId() : null);

	            return clienteDTO;
	        } catch (Exception e) {
	            throw e;
	        }
	    }

	    @Transactional(readOnly = true)
	    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO)
	        throws Exception {
	        try {
	            Cliente cliente = new Cliente();

	            cliente.setClieId(clienteDTO.getClieId());
	            cliente.setActivo((clienteDTO.getActivo() != null)
	                ? clienteDTO.getActivo() : null);
	            cliente.setDireccion((clienteDTO.getDireccion() != null)
	                ? clienteDTO.getDireccion() : null);
	            cliente.setEmail((clienteDTO.getEmail() != null)
	                ? clienteDTO.getEmail() : null);
	            cliente.setNombre((clienteDTO.getNombre() != null)
	                ? clienteDTO.getNombre() : null);
	            cliente.setTelefono((clienteDTO.getTelefono() != null)
	                ? clienteDTO.getTelefono() : null);

	            TipoDocumento tipoDocumento = new TipoDocumento();

	            if (clienteDTO.getTdocId() != null) {
	                tipoDocumento = tipoDocumentoService.findById(clienteDTO.getTdocId());
	            }

	            if (tipoDocumento != null) {
	                cliente.setTipoDocumento(tipoDocumento);
	            }

	            return cliente;
	        } catch (Exception e) {
	            throw e;
	        }
	    }

	    @Transactional(readOnly = true)
	    public List<ClienteDTO> listClienteToListClienteDTO(
	        List<Cliente> listCliente) throws Exception {
	        try {
	            List<ClienteDTO> clienteDTOs = new ArrayList<ClienteDTO>();

	            for (Cliente cliente : listCliente) {
	                ClienteDTO clienteDTO = clienteToClienteDTO(cliente);

	                clienteDTOs.add(clienteDTO);
	            }

	            return clienteDTOs;
	        } catch (Exception e) {
	            throw e;
	        }
	    }

	    @Transactional(readOnly = true)
	    public List<Cliente> listClienteDTOToListCliente(
	        List<ClienteDTO> listClienteDTO) throws Exception {
	        try {
	            List<Cliente> listCliente = new ArrayList<Cliente>();

	            for (ClienteDTO clienteDTO : listClienteDTO) {
	                Cliente cliente = clienteDTOToCliente(clienteDTO);

	                listCliente.add(cliente);
	            }

	            return listCliente;
	        } catch (Exception e) {
	            throw e;
	        }
	    }

}
