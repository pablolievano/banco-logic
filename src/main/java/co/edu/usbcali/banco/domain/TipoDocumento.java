package co.edu.usbcali.banco.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the tipo_documento database table.
 * 
 */
@Entity
@Table(name="tipo_documento")
@NamedQuery(name="TipoDocumento.findAll", query="SELECT t FROM TipoDocumento t")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tdoc_id")
	@NotNull
	private Long tdocId;
	
	@NotNull
	@Pattern(regexp = "^[SN]$",message="Solo permite los valores S o N")
	private String activo;
	
	@NotNull
	@Size(min=5,max=50)
	private String nombre;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tipoDocumento")
	private List<Cliente> clientes;

	public TipoDocumento() {
	}

	public Long getTdocId() {
		return this.tdocId;
	}

	public void setTdocId(Long tdocId) {
		this.tdocId = tdocId;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setTipoDocumento(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setTipoDocumento(null);

		return cliente;
	}

}