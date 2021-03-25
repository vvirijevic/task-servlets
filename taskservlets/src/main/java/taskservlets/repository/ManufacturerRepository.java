package taskservlets.repository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import taskservlets.model.Manufacturer;
@WebListener("Configuration")
public class ManufacturerRepository implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Manufacturer> manufacturers = new ArrayList<>();
		sce.getServletContext().setAttribute("manufacturers", manufacturers);
	}

}
