package co.edu.usbcali.banco.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clie_id")
	@NotNull
	private long clieId;
	
	@NotNull
	@Pattern(regexp = "^[SN]$",message="Solo permite los valores S o N")
	private String activo;
	
	@NotNull
	@Size(min=5,max=50)
	private String direccion;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min=5,max=50)
	private String nombre;
	
	@NotNull
	@Size(min=5,max=50)
	private String telefono;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tdoc_id")
	@NotNull
	private TipoDocumento tipoDocumento;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="cliente")
	private List<Cuenta> cuentas;

	//bi-directional many-to-one association to CuentaRegistrada
	@OneToMany(mappedBy="cliente")
	private List<CuentaRegistrada> cuentaRegistradas;

	public Cliente() {
	}

	public long getClieId() {
		return this.clieId;
	}

	public void setClieId(long clieId) {
		this.clieId = clieId;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setCliente(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setCliente(null);

		return cuenta;
	}

	public List<CuentaRegistrada> getCuentaRegistradas() {
		return this.cuentaRegistradas;
	}

	public void setCuentaRegistradas(List<CuentaRegistrada> cuentaRegistradas) {
		this.cuentaRegistradas = cuentaRegistradas;
	}

	public CuentaRegistrada addCuentaRegistrada(CuentaRegistrada cuentaRegistrada) {
		getCuentaRegistradas().add(cuentaRegistrada);
		cuentaRegistrada.setCliente(this);

		return cuentaRegistrada;
	}

	public CuentaRegistrada removeCuentaRegistrada(CuentaRegistrada cuentaRegistrada) {
		getCuentaRegistradas().remove(cuentaRegistrada);
		cuentaRegistrada.setCliente(null);

		return cuentaRegistrada;
	}

}