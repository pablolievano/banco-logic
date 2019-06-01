package co.edu.usbcali.banco.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cuen_id")
	private String cuenId;

	private String activa;

	private String clave;

	private BigDecimal saldo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;

	//bi-directional many-to-one association to CuentaRegistrada
	@OneToMany(mappedBy="cuenta")
	private List<CuentaRegistrada> cuentaRegistradas;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="cuenta")
	private List<Transaccion> transaccions;

	public Cuenta() {
	}

	public String getCuenId() {
		return this.cuenId;
	}

	public void setCuenId(String cuenId) {
		this.cuenId = cuenId;
	}

	public String getActiva() {
		return this.activa;
	}

	public void setActiva(String activa) {
		this.activa = activa;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CuentaRegistrada> getCuentaRegistradas() {
		return this.cuentaRegistradas;
	}

	public void setCuentaRegistradas(List<CuentaRegistrada> cuentaRegistradas) {
		this.cuentaRegistradas = cuentaRegistradas;
	}

	public CuentaRegistrada addCuentaRegistrada(CuentaRegistrada cuentaRegistrada) {
		getCuentaRegistradas().add(cuentaRegistrada);
		cuentaRegistrada.setCuenta(this);

		return cuentaRegistrada;
	}

	public CuentaRegistrada removeCuentaRegistrada(CuentaRegistrada cuentaRegistrada) {
		getCuentaRegistradas().remove(cuentaRegistrada);
		cuentaRegistrada.setCuenta(null);

		return cuentaRegistrada;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setCuenta(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setCuenta(null);

		return transaccion;
	}

}