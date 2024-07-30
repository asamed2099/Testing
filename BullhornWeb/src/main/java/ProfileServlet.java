

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.DbUserOperations;
import studs.User;

import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name="ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProfileServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("running");
		/*
		* simplify this so that it always requires two
		parameters, userid and action
		* action is view or edit. If edit then the
		userID of the session(user) must be same as
		userID for profile 
		* since you can only edit your own.
		* all urls coming to this page must contain
		both parameters or get error.
		 */
		HttpSession session = request.getSession();
		String nextUrl="/error.jsp";
		long userid =0;
		String action="";
		User profileUser=null;
		User loggedInUser = null;
		
		//get user out of session. If they don't exist
		//then send them back to the login page.
		//kill the session while you're at it.
		
		if (session.getAttribute("user")==null){
			nextUrl= "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.
			getContextPath() + nextUrl);
			return;//return prevents an error
			}
		
		try {
			
			//userid = Long.parseLong(request.getParameter("userid"));
			userid = 1;
			action = request.getParameter(action);
			
			//update profile for user in request variable
			//if action ==updateProfile
			if(request.getParameter("action").equals("updateprofile")) {
				long uid =Long.parseLong(request.getParameter("userid"));
				String userEmail= request.getParameter("email");
				
				String userMotto= request.getParameter("motto");
				User updateUser = DbUserOperations.getUser(userid);
				updateUser.setMotto(userMotto);
				updateUser.setEmail(userEmail);
				DbUserOperations.update(updateUser);
				
			}
			//get the user from the parameter
			profileUser = DbUserOperations.getUser(userid);
			//get the current user out of the session
			loggedInUser = (User) session.getAttribute("user");	
			
			if (profileUser.getBhuser_id()==loggedInUser.getBhuser_id()){
					//display profile as form
					//the session variable editProfile is
					//used by the JSP to
					//display the profile in edit mode
				 session.setAttribute("editProfile", true);
				}else {
					//display profile read-only
					//the session variable editProfile is
					// used by the JSP to
					//display the profile in read-only mode
					session.setAttribute("editProfile",
					false);
				}
			//populate the data in the attributes
			int imgSize = 120;
			SimpleDateFormat sdf = new SimpleDateFormat
			("MMM d, yyyy");
			String joindate = sdf.format(profileUser.
			getJoindate());
			request.setAttribute("userid", profileUser.getBhuser_id());
			request.setAttribute("userimage",DbUserOperations.getGravatarUrl(profileUser.getEmail(), imgSize));
			
			request.setAttribute("fullname", profileUser.getFullname());
			request.setAttribute("email", profileUser.getEmail());
			request.setAttribute("motto", profileUser.getMotto());
			request.setAttribute("userjoinDate", profileUser.getJoindate());
			nextUrl="/profile.jsp";
		} catch (Exception e) {
			//print the exception so we can see it
			//while testing the application
			//in production it isn't a good idea to
			//print to the console since it
			//consumes resources and will not be seen
			e.printStackTrace();
		}
		
		//redirect to next page as indicated by the
		//value of the nextURL variable
		getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

}
