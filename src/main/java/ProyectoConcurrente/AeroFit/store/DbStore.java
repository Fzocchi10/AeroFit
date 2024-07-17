package ProyectoConcurrente.AeroFit.store;

import java.util.ArrayList;
import java.util.Collection;


import ProyectoConcurrente.AeroFit.entity.Vuelo;


public class DbStore {
    private static DbStore instance = new DbStore();
    private Collection<Vuelo> vuelos;

    private DbStore() {
    	vuelos = new ArrayList<>();
    	Vuelo vuelo1 = new Vuelo(1001, 100);
    	Vuelo vuelo2 = new Vuelo(1002, 90);
    	vuelos.add(vuelo1);
    	vuelos.add(vuelo2);
        
    }

    public static DbStore getInstance() {
        return instance;
    }

    public ArrayList<Vuelo> getVuelos() {
        return (ArrayList<Vuelo>) this.vuelos;
    }
    
    public Collection<Vuelo> findAll(){
		return this.vuelos;
	}
    
    public void setVuelos(Collection<Vuelo> vuelos) {
    	this.vuelos = vuelos;
    }

    public Vuelo getVuelo(Integer numeroDeVuelo) {
    	return this.vuelos.stream()
    			.filter(v -> v.getNumeroVuelo().equals(numeroDeVuelo))
    			.findFirst()
    			.orElse(null);
    }
}