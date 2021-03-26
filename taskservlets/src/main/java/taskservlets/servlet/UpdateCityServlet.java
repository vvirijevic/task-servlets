package taskservlets.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import taskservlets.model.City;
@WebServlet(urlPatterns = {"/updatecity"})
public class UpdateCityServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexParam = req.getParameter("index");
		@SuppressWarnings("unchecked")
		List<City> list = (List<City>) req.getServletContext().getAttribute("cities");
		updateCity(list.get(Integer.parseInt(indexParam)), 0, "");
		
	}
	
	public void updateCity(City c, int newPTT, String newName) {
		c = new City(newPTT, newName);
	}
}
