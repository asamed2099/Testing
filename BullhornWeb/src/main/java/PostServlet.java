

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.DbPostOperations;
import studs.Post;
import studs.User;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String posttext = request.getParameter("posttext");
		
		String nextUrl = "/posterror";
		//Get user out of session. If they don't exist then
		//end the session and send them back to the login page.
	
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			
			nextUrl = "login.jsp";
			session.invalidate();
		}else {
			// Get the user out of the session 
			User user = (User)session.getAttribute("user");
			
			//insert the post 
			Post post = new Post();
			post.setUser(user);;
			Date postdate = Calendar.getInstance().getTime();
			
			post.setPostdate(postdate);
			DbPostOperations.insert(post);
			nextUrl = "/NewsFeed"; // go to newsfeed servlet to show all posts
		}
		//the value of nextURL will be newsfeed, login, or error
		getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
