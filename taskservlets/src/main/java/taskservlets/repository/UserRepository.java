package taskservlets.repository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import taskservlets.model.User;




@WebListener("Configuration")
public class UserRepository implements ServletContextListener{
	
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		List<User> users = new ArrayList<>();
		users.add(new User("Admin", "Admin", "admin@admin.com", "admin"));
		users.add(new User("Vladan", "Virijevic", "viks@viks.com", "viks123"));
		sce.getServletContext().setAttribute("users", users);
		
	}
	
	
}
