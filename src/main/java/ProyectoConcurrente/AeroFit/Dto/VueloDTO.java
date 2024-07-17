package ProyectoConcurrente.AeroFit.Dto;

import ProyectoConcurrente.AeroFit.entity.Vuelo;

public class VueloDTO {
	private Integer numeroVuelo;
	private Integer pasajes;
	private Integer pasajesVendidos;
	
	public VueloDTO(Integer numeroVuelo, Integer pasajes, Integer pasajesVendidos) {
		this.numeroVuelo = numeroVuelo;
		this.pasajes = pasajes;
		this.pasajesVendidos = pasajesVendidos;
	}
	
	public VueloDTO() {}

	public Vuelo toModel() {
		Vuelo vueloModel = new Vuelo();
		
		vueloModel.setNumeroVuelo(this.numeroVuelo);
		vueloModel.setPasajesDisponibles(this.pasajes);
		vueloModel.setPasajesVendidos(this.pasajesVendidos);
		
		return vueloModel;
	}

	
	public Integer getNumeroVuelo() {
		return this.numeroVuelo;
	}
	
	public void setNumeroVuelo(Integer numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	
	public Integer getPasajes() {
		return pasajes;
	}

	public void setPasajes(Integer pasajes) {
		this.pasajes = pasajes;
	}

	public Integer getPasajesVendidos() {
		return pasajesVendidos;
	}

	public void setPasajesVendidos(Integer pasajesVendidos) {
		this.pasajesVendidos = pasajesVendidos;
	}
}
