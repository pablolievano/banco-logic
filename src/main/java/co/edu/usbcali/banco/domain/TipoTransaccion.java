package co.edu.usbcali.banco.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_transaccion database table.
 * 
 */
@Entity
@Table(name="tipo_transaccion")
@NamedQuery(name="TipoTransaccion.findAll", query="SELECT t FROM TipoTransaccion t")
public class TipoTransaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="titr_id")
	private Long titrId;

	private String activo;

	private String nombre;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="tipoTransaccion")
	private List<Transaccion> transaccions;

	public TipoTransaccion() {
	}

	public Long getTitrId() {
		return this.titrId;
	}

	public void setTitrId(Long titrId) {
		this.titrId = titrId;
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

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setTipoTransaccion(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setTipoTransaccion(null);

		return transaccion;
	}

}