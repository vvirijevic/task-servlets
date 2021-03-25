package taskservlets.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import taskservlets.model.City;

@WebServlet(urlPatterns="/cityservlet")
public class CityServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
		String ptt = req.getParameter("PTT");
		String name = req.getParameter("naziv");
		
		//HttpSession session = req.getSession(true);
		City c = new City(Integer.parseInt(ptt), name);
		cities.add(c);
		req.setAttribute("cities", cities);
		req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexParam = req.getParameter("index");
		@SuppressWarnings("unchecked")
		List<City> list = (List<City>) req.getServletContext().getAttribute("cities");
		list.remove(Integer.parseInt(indexParam));
		req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
	}
	
	protected void saveCity(City c, HttpServletRequest req) {
		@SuppressWarnings("unchecked")
		List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
		cities.add(c);
		req.setAttribute("cities", cities);
	}
}
