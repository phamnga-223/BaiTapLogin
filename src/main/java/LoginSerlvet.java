import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginSerlvet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username != null && !username.equals("") && password != null && !password.equals("")) {
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath + "/welcome?username=" + username + "&password=" + password);
		} else {
			String error = "Username & Password không được để trống";
			req.setAttribute("error", error);
			System.out.println(error);
			doGet(req, resp);
		}
	}
}
