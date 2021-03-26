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
import taskservlets.model.Product;
@WebServlet("/manufservlet")
public class ManufacturerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexParam = req.getParameter("index");
		@SuppressWarnings("unchecked")
		List<Manufacturer> manufacturers = (List<Manufacturer>) req.getServletContext().getAttribute("manufacturers");
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) req.getServletContext().getAttribute("products");
		for (Product p : products) {
			if(p.getProizvodjac().getNaziv().equals(manufacturers.get(Integer.parseInt(indexParam)).getNaziv())) {
				req.setAttribute("message", "Can't delete manufacturer that already contains products in Product Table");
				req.getRequestDispatcher("/errorform.jsp").forward(req, resp);
			} else {
				manufacturers.remove(Integer.parseInt(indexParam));
				req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
			}
		}
		
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
