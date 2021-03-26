package taskservlets.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import taskservlets.model.City;
import taskservlets.model.Manufacturer;

@WebServlet(urlPatterns="/cityservlet")
public class CityServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
		String ptt = req.getParameter("PTT");
		String name = req.getParameter("naziv");
		
		if(ptt.length()!=5) {
			req.setAttribute("message", "Error : PTT must be 5 digits long!");
			req.getRequestDispatcher("/errorform.jsp").forward(req, resp);
		} else {
			City c = new City(Integer.parseInt(ptt), name);
			cities.add(c);
			req.setAttribute("cities", cities);
			req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexParam = req.getParameter("index");
		@SuppressWarnings("unchecked")
		List<City> list = (List<City>) req.getServletContext().getAttribute("cities");
		@SuppressWarnings("unchecked")
		List<Manufacturer> manufacturers = (List<Manufacturer>) req.getServletContext().getAttribute("manufacturers");
		if(existsInList(list, manufacturers)) {
			req.setAttribute("message", "Can't delete city that already contains manufacturer in Manufacturer Table");
			req.getRequestDispatcher("/errorform.jsp").forward(req, resp);
		} else {
			list.remove(Integer.parseInt(indexParam));
			req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
		}
		
	}
	
	protected void saveCity(City c, HttpServletRequest req) {
		@SuppressWarnings("unchecked")
		List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
		cities.add(c);
		req.setAttribute("cities", cities);
	}
	
	protected boolean existsInList(List<City> cities, List<Manufacturer> manufacturers) {
		for (int i = 0; i < manufacturers.size(); i++) {
			for (int j = 0; j < cities.size(); j++) {
				if(manufacturers.get(i).getGrad().getPTT() == cities.get(j).getPTT()) {
					return true;
				}
			}
		}
		return false;
	}
}
