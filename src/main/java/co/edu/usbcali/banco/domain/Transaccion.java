package co.edu.usbcali.banco.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tran_id")
	private Long tranId;

	private Timestamp fecha;

	private BigDecimal valor;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="cuen_id")
	private Cuenta cuenta;

	//bi-directional many-to-one association to TipoTransaccion
	@ManyToOne
	@JoinColumn(name="titr_id")
	private TipoTransaccion tipoTransaccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usu_usuario")
	private Usuario usuario;

	public Transaccion() {
	}

	public Long getTranId() {
		return this.tranId;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public TipoTransaccion getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}