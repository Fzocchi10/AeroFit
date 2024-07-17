package ProyectoConcurrente.AeroFit.entity;

import java.util.ArrayList;
import java.util.Collection;

import ProyectoConcurrente.AeroFit.Dto.VueloDTO;

public class Vuelo {
	private Integer numeroVuelo;
	private Integer pasajesDisponibles;
	private Integer pasajesVendidos;
	private Collection<Pasajero> ventas;
	
	
	public Vuelo(Integer numeroVuelo, Integer pasajes) {
		this.numeroVuelo = numeroVuelo;
		this.pasajesDisponibles = pasajes;
		this.pasajesVendidos = 0;
		this.ventas = new ArrayList<Pasajero>();
	}
	
	public Vuelo() {}

	public VueloDTO toDto() {
		VueloDTO vueloDto = new VueloDTO();
		
		vueloDto.setPasajes(this.pasajesDisponibles);
		vueloDto.setPasajesVendidos(this.pasajesVendidos);
		vueloDto.setNumeroVuelo(this.numeroVuelo);
		
		return vueloDto;
	}
	
	public void guardarVenta(Pasajero venta) {
		this.ventas.add(venta);
	}
	
	public void sumarPasajesVendidos(Integer cantidadPasajes) {
		this.pasajesVendidos += cantidadPasajes;
	}
	
	public void ventaPasajes(Integer pasajes) {
		this.pasajesDisponibles -= pasajes;
	}
	
	public Integer getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(Integer numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public Integer getPasajesDisponibles() {
		return pasajesDisponibles;
	}

	public void setPasajesDisponibles(Integer pasajes) {
		this.pasajesDisponibles = pasajes;
	}

	public Integer getPasajesVendidos() {
		return pasajesVendidos;
	}

	public void setPasajesVendidos(Integer pasajesVendidos) {
		this.pasajesVendidos = pasajesVendidos;
	}

	public Collection<Pasajero> getVentas() {
		return this.ventas;
	}

	public void setVentas(Collection<Pasajero> ventas) {
		this.ventas = ventas;
	}
}

