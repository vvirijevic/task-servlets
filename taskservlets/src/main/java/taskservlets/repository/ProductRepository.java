package taskservlets.repository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import taskservlets.model.Product;
@WebListener("Configuration")
public class ProductRepository implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Product> products = new ArrayList<>();
		sce.getServletContext().setAttribute("products", products);
	}

}
