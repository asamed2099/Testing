

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import jakarta.servlet.http.HttpSession;
import service.DbUserOperations;
import studs.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		//String action = request.getParameter("remember");
		
		String nextUrl="/loginError.jsp";
		//get an instance of the session so we can set attributes to it
		//the JSP and NavBar will read from the session
		//The session is one of the primary ways we maintain state
		//in an otherwise stateless web application
		
		
		HttpSession session = request.getSession();
		
		String error ="Error";
		//create an instance of the user and put it in the session
		//only add the user to the session if the user if valid.
		//The presence of the user is used to determine who
		//owns the site and will be used to connect to
		
		//create an instance of the user and put it in the session
		//only add the user to the session if the user if valid.
		//The presence of the user is used to determine who
		//owns the site and will be used to connect to the database
		/*
		if(!action.equals("logout")) {
			session.invalidate();
			nextUrl="/login.jsp";
			 System.out.println("logout");
		}else {
		*/
			if(DbUserOperations.isUserValid(email, password)) {
				User user = DbUserOperations.getUserByEmail(email);
				session.setAttribute("user", user);
				int gravatarImageWidth=80;
				String gravatarURL ="";
				try {
					 gravatarURL =
							DbUserOperations.getGravatarUrl(email, gravatarImageWidth);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("gravaterUrl", gravatarURL);	
				  nextUrl="/newsfeed.jsp";
				  System.out.println("Login successful!!");
			}else {
				//request.setAttribute("error", session);
				nextUrl ="/loginError.jsp";
				 System.out.println("Login unsuccessful!!");
			}
		
		
		//redirect to next page as indicated by thevalue of the nextURL variable
		getServletContext().getRequestDispatcher(nextUrl).forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
