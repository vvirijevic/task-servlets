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
@WebServlet("/manufservlet")
public class ManufacturerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexParam = req.getParameter("index");
		@SuppressWarnings("unchecked")
		List<Manufacturer> manufacturers = (List<Manufacturer>) req.getServletContext().getAttribute("manufacturers");
		manufacturers.remove(Integer.parseInt(indexParam));
		req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Manufacturer> manufacturers = (List<Manufacturer>) req.getServletContext().getAttribute("manufacturers");
		int pib = Integer.parseInt(req.getParameter("pib"));
		int mbr = Integer.parseInt(req.getParameter("mbr"));
		String naziv = req.getParameter("naziv");
		String adresa = req.getParameter("adresa");
		int ptt = Integer.parseInt(req.getParameter("city"));
		
		Manufacturer m = new Manufacturer(pib, mbr, naziv, adresa, new City(ptt, ""));
		manufacturers.add(m);
		req.setAttribute("manufacturers", manufacturers);
		req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
	}
}
