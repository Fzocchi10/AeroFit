package ProyectoConcurrente.AeroFit.Monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Component;

@Component("Monitor")
public class Monitor {
		private Lock lock;
		private Condition esperandoConexion;
		private Integer cantidadMaximaDeConexiones;
		
		public Monitor() {
			this.lock = new ReentrantLock();
			this.esperandoConexion = this.lock.newCondition();
			this.cantidadMaximaDeConexiones = 5;
		}
		
		public void filterAccess() {
			try {
				this.lock.lock();
				while(this.cantidadMaximaDeConexiones > 5) {
					this.esperandoConexion.await();
				}
				this.cantidadMaximaDeConexiones ++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.lock.unlock();
			}
		}
		
		public void closeConnection() {
			this.lock.lock();
			this.cantidadMaximaDeConexiones --;
			this.esperandoConexion.signal();
			this.lock.unlock();
		}
}
