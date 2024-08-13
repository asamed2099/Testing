

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.DbUserOperations;
import studs.Post;
import studs.PostBean;
import studs.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name="ProfileServlet", urlPatterns = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProfileServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String nextUrl="/error.jsp";
		int userid =0;
	

		
		if (session.getAttribute("user")==null){
			nextUrl= "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.
			getContextPath() + nextUrl);
			return;//return prevents an error
			}
		
		try {
			User user =(User)session.getAttribute("user");
			userid = user.getBhuser_id();
			List<Post>userposts = PostBean.userPosts(userid);
			request.setAttribute("userposts", userposts);
			request.setAttribute("editProfile", true);
			
			nextUrl="/profile.jsp";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

}
