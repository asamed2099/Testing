

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;
@WebServlet(name ="Logout" ,  urlPatterns = "/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		//getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
		//response.sendRedirect("login.jsp");
		request.setAttribute("logsuccess", "Logged Out Successful!!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		// <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
