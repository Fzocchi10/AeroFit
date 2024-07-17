package ProyectoConcurrente.AeroFit.Service;




import org.springframework.stereotype.Service;
import ProyectoConcurrente.AeroFit.entity.Pasajero;
import ProyectoConcurrente.AeroFit.entity.Vuelo;


@Service
public class VueloService{
	
	public synchronized static String registrarVenta(Vuelo vuelo, Pasajero pasajero) {
		
		if(pasajero.getPasajesComprados() > vuelo.getPasajesDisponibles()) {
			return "No hay pasajes suficientes";
		} else {
			vuelo.setPasajesVendidos(pasajero.getPasajesComprados());
			vuelo.sumarPasajesVendidos(pasajero.getPasajesComprados());
			vuelo.guardarVenta(pasajero);
			return "Pasajes confirmados";
		}
		
	}
}
