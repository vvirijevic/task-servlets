package taskservlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import taskservlets.model.User;
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		boolean found = false;
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) req.getServletContext().getAttribute("users");
		for (User u : users) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				found = true;
				HttpSession session = req.getSession();
				session.setAttribute("user", new User(u.getIme(), u.getPrezime(), u.getEmail(), ""));
				break;
			}
		}
		if(found) {
			req.getRequestDispatcher("/glavna.jsp").forward(req, resp);
		} else {
			req.setAttribute("message", "Invalid User");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);;
		}
	}
}
