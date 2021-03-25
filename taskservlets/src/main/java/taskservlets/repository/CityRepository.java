package taskservlets.repository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import taskservlets.model.City;
@WebListener("Configuration")
public class CityRepository implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<City> cities = new ArrayList<>();
		sce.getServletContext().setAttribute("cities", cities);
	}

}
