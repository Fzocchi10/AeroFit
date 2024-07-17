package ProyectoConcurrente.AeroFit.entity;

import ProyectoConcurrente.AeroFit.Dto.PasajeroDTO;

public class Pasajero {

	private String nombre;
	private String apellido;
	private Integer cantDePasajes;
	
	
	public Pasajero(String nombre, String apellido, Integer cantDePasajes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantDePasajes = cantDePasajes;
	}

	public Pasajero() {}
	
	
	public PasajeroDTO toDto() {
		PasajeroDTO pasajereDto = new PasajeroDTO();
		
		pasajereDto.setNombre(this.nombre);
		pasajereDto.setApellido(this.apellido);
		pasajereDto.setCantDePasajes(this.cantDePasajes);
		
		return pasajereDto;
	}
	
	
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

	public Integer getPasajesComprados() {
		return cantDePasajes;
	}

	public void setPasajesComprados(Integer cantDePasajes) {
		this.cantDePasajes = cantDePasajes;
	}

}
