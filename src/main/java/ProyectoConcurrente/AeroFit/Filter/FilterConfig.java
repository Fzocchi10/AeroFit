package ProyectoConcurrente.AeroFit.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ProyectoConcurrente.AeroFit.Monitor.Monitor;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;


@Component
public class FilterConfig implements Filter {
		
		@Autowired
		private Monitor monitor;
		
		
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			
			monitor.filterAccess();
			chain.doFilter(request, response);
			monitor.closeConnection();
			
		}

}
