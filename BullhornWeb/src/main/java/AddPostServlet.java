

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
import java.util.Date;

import com.mysql.cj.Session;


public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddPostServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nextUrl ="/error.jsp";
		//String postText=request.getAttribute("post");
		String postText = request.getParameter("post");
		Date postDate =new Date();
		User user =(User)session.getAttribute("user"); 
		int userid = (Integer)user.getBhuser_id();
		Post post = new Post(postDate,postText,user);
		
		// Insert post 
		DbPostOperations.insert(post);
		nextUrl ="/profile.jsp";
		System.out.println("post created successfully!!");
		getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
