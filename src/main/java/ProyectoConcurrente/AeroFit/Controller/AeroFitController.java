package ProyectoConcurrente.AeroFit.Controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProyectoConcurrente.AeroFit.entity.Pasajero;
import ProyectoConcurrente.AeroFit.entity.Vuelo;
import ProyectoConcurrente.AeroFit.store.DbStore;
import ProyectoConcurrente.AeroFit.Dto.VentaDTO;
import ProyectoConcurrente.AeroFit.Dto.VueloDTO;
import ProyectoConcurrente.AeroFit.Service.VueloService;

@RestController
@RequestMapping("/vuelos")
public class AeroFitController {
	
	@GetMapping("/todosLosVuelos")
	public ResponseEntity<?> getVuelos(){
		Collection<Vuelo> vuelos = DbStore.getInstance().findAll();
		Collection<VueloDTO> vuelosDTO = new ArrayList<VueloDTO>();
		
		vuelos.forEach(v -> vuelosDTO.add(v.toDto()));
		
		return ResponseEntity.ok(vuelosDTO);
	}
	
	@GetMapping("/vuelo/{numeroVuelo}")
	public ResponseEntity<?>getVueloById(@PathVariable Integer numeroVuelo){
		VueloDTO vueloDto = DbStore.getInstance().getVuelo(numeroVuelo).toDto();
		
		return ResponseEntity.ok(vueloDto);
	}
	
	@PutMapping("/ventaPasaje")
	public ResponseEntity<?> ventaPasaje(@RequestBody VentaDTO venta){
		Integer numeroVuelo = venta.getNumeroVuelo();
		Vuelo vuelo = DbStore.getInstance().getVuelo(numeroVuelo);
		Pasajero pasajeroModel = new Pasajero(venta.getNombre(), venta.getApellido(), venta.getPasajesVendidos());
		
		return ResponseEntity.ok(VueloService.registrarVenta(vuelo, pasajeroModel));
	}
}