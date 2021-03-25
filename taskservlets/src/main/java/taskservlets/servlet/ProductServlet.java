package taskservlets.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import taskservlets.model.Manufacturer;
import taskservlets.model.Product;
@WebServlet("/productservlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) req.getServletContext().getAttribute("products");
		int sifra = Integer.parseInt(req.getParameter("id"));
		String naziv = req.getParameter("naziv");
		double cena = Double.parseDouble(req.getParameter("cena"));
		double poreskaStopa = Double.parseDouble(req.getParameter("poreskaStopa"));
		String valuta = req.getParameter("valuta");
		String mernaJedinica = req.getParameter("mernaJedinica");
		String proizvodjac = req.getParameter("proizvodjac");
		
		Product p = new Product(sifra, naziv, cena, poreskaStopa, valuta, mernaJedinica, new Manufacturer(0, 0, proizvodjac, "", null));
		products.add(p);
		
		req.setAttribute("products", products);
		req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexParam = req.getParameter("index");
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) req.getServletContext().getAttribute("products");
		products.remove(Integer.parseInt(indexParam));
		req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
	}
}
