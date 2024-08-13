

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import studs.User;

import java.io.IOException;

public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ChangePassword() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		//String userpassword = user.getPassword().;
		if(user.getPassword().equals(oldpassword) ){
			user.setPassword(newpassword);
			session.setAttribute("success", true);
			System.out.println("Password changed successfully!!");
		}else {
			System.out.println("Unsuccessful");
		}
		getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
