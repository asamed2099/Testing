

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


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String searchText = "";
		
		String nextURL = "";
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
		
		//get posts based on parameters; if no parameters then get all posts
		List<Post> posts = null;
		if(request.getParameter("searchtext")!=null && !request.getParameter("searchtext").isEmpty()) {
			searchText = request.getParameter("searchtext").toString();
			posts= DbPostOperations.searchPosts(searchText);
		}else {
			//posts = DbPostOperations.posts();
		}
	
		//add posts to request
		request.setAttribute("search", searchText);
		session.setAttribute("searchposts", posts);
		//display posts in newsfeed.jsp
		nextURL = "/viewSearch.jsp";
		//redirect to next page as indicated by the value of the nextURL variable
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
