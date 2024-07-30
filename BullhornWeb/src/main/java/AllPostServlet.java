

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.DbPostOperations;
import studs.Post;

import java.io.IOException;
import java.util.List;

public class AllPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AllPostServlet() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long filterByUserId = 0;
		String searchText = "";
		
		String nextURL = "/loginError.jsp";
		//get user out of session.
		//If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null){
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
		return;//return prevents an error
		}
		
		// get all posts
		List<Post> posts = null;
		
			posts = DbPostOperations.posts();
		
	
		//add posts to request
		request.setAttribute("allposts", posts);
		session.setAttribute("allposts", posts);
		
		nextURL = "/newsfeed.jsp";
		//redirect to next page as indicated by the value of the nextURL variable
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
