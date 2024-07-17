package ProyectoConcurrente.AeroFit.Dto;

import ProyectoConcurrente.AeroFit.entity.Pasajero;

public class PasajeroDTO {
	private String nombre;
	private String apellido;
	private Integer cantDePasajes;
	
	public PasajeroDTO() {}
	
	public PasajeroDTO(String nombre, String apellido, Integer cantDePasajes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantDePasajes = cantDePasajes;
	}
	
	public Pasajero toModel() {
		Pasajero modelPasajere = new Pasajero();
		
		modelPasajere.setNombre(this.nombre);
		modelPasajere.setApellido(this.apellido);
		modelPasajere.setPasajesComprados(cantDePasajes);
		
		return modelPasajere;
	}

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getCantDePasajes() {
		return cantDePasajes;
	}

	public void setCantDePasajes(Integer cantDePasajes) {
		this.cantDePasajes = cantDePasajes;
	}
	
}
