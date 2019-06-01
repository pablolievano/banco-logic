package co.edu.usbcali.banco.dto;

public class ClienteDTO {
	
	private long clieId;
	private String activo;
	private String direccion;
	private String email;
	private String nombre;
	private String telefono;
	private Long tdocId;
	
	
	
	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(long clieId, String activo, String direccion, String email, String nombre, String telefono,
			Long tdocId) {
		super();
		this.clieId = clieId;
		this.activo = activo;
		this.direccion = direccion;
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
		this.tdocId = tdocId;
	}
	public long getClieId() {
		return clieId;
	}
	public void setClieId(long clieId) {
		this.clieId = clieId;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getTdocId() {
		return tdocId;
	}
	public void setTdocId(Long tdocId) {
		this.tdocId = tdocId;
	}
	
	
	

}
