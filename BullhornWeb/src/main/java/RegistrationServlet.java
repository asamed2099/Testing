

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DbUserOperations;
import studs.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JSpinner.DateEditor;


public class RegistrationServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public RegistrationServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String motto = request.getParameter("motto");
		//request.getLocale();
		/*
		SimpleDateFormat ft=new SimpleDateFormat();
		Date dobDate =null;
		try {
			dobDate = ft.parse(dob);
			System.out.println(dobDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}*/
		Date joinDate = new Date();
		User user = new User(fullname, password, email, phone, gender, dob, motto, joinDate );
		
		DbUserOperations.insert(user);
		request.setAttribute("status", "success" );
		request.getRequestDispatcher("/register.jsp").forward(request, response);
		System.out.println("Registration successful, records inserted");
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

}
