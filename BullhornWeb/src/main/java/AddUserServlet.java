

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.DbUserOperations;
import studs.User;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddUserServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//This page does not require user to be logged in
		String username = request.getParameter("fullname");
		String userEmail = request.getParameter("email");
				String userPassword = request.getParameter
				("password");
				String userMotto = request.getParameter
				("motto");
				String nextURL = "/error.jsp";
				//check if user exists (by email)
				User user = DbUserOperations.getUserByEmail(userEmail);
				//create user and add them if they don't exit
				if (user == null){
				user = new User();
				user.setFullname(username);
				user.setEmail(userEmail);
				user.setPassword(userPassword);
				Date joindate = Calendar.getInstance().getTime();
				user.setJoindate(joindate);
				user.setMotto(userMotto);
				
				DbUserOperations.insert(user);
				nextURL ="/index.jsp";
				
				}else{
					String message = "You have an account - ";
					request.setAttribute("message",
					message);
					nextURL = "/login.jsp";
					}
				//add the user to the session
				session.setAttribute("user", user);
				//redirect to next page as indicated by the
				//value of the nextURL variable
				getServletContext().getRequestDispatcher(nextURL).forward(request,response);
				
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
