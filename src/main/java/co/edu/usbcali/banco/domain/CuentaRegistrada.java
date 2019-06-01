package co.edu.usbcali.banco.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuenta_registrada database table.
 * 
 */
@Entity
@Table(name="cuenta_registrada")
@NamedQuery(name="CuentaRegistrada.findAll", query="SELECT c FROM CuentaRegistrada c")
public class CuentaRegistrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cure_id")
	private Long cureId;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="cuen_id")
	private Cuenta cuenta;

	public CuentaRegistrada() {
	}

	public Long getCureId() {
		return this.cureId;
	}

	public void setCureId(Long cureId) {
		this.cureId = cureId;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}