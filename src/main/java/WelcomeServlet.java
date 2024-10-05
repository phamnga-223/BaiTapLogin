import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "welcomeServlet", urlPatterns = {"/", "/welcome"})
public class WelcomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "Xin chào ";
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username != null && !username.equals("") && password != null && !password.equals("")) {
			message = message + username + " - " + password;
		}
		req.setAttribute("message", message);
		
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);
	}
}
