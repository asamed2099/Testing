

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.DbUserOperations;
import service.UserInfoOperations;
import studs.User;
import studs.UserInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import com.mysql.cj.Session;

@MultipartConfig(location = "C:\\Users\\asamed2099\\eclipse-workspace2\\BullhornWeb\\src\\main\\webapp\\uploads", fileSizeThreshold = 1024 + 1024, // 1MB
maxFileSize = 1024 * 1024 * 10, // 10MB File Size
maxRequestSize = 1024 * 1024 * 11 // 11MB
)
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditProfileServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		
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
		String profilephoto="";
		String jobtitle = request.getParameter("job");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String bio = request.getParameter("bio");
		User loggeduser =(User) session.getAttribute("user");
		int userid = (int)loggeduser.getBhuser_id();
		// Get the profile photo 
		Part part = request.getPart("profilephoto");
		String contentDisposition= part.getHeader("content-disposition");
		
		
	
		try {
			part.write(getFileName(part));
			profilephoto = getFileName(part).toString();
			System.out.println(profilephoto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Date updatednow = new Date();
		
		
		
		
		
		//Update Personal Information
		//User user = new User(fullname,email,phone,dob, motto );
		User user = (User)session.getAttribute("user");
			user.setFullname(fullname);
			user.setEmail(email);
			user.setPhone(phone);
			user.setDob(dob);
			
				
		//DbUserOperations.update(user);
		
		//Seth address and other information
		
		//UserInfo userInfo = new UserInfo(jobtitle, profilephoto, address,city, country,bio,userid,updatednow);
		UserInfo userInfo =(UserInfo)UserInfoOperations.getUserByUserId(user.getBhuser_id());	
			if (userInfo !=null) {
				userInfo.setJobtitle(jobtitle);
				userInfo.setPhoto(profilephoto);
				userInfo.setAddress(address);
				userInfo.setCity(city);
				userInfo.setCountry(country);
				userInfo.setBio(bio);
				userInfo.setUserid(userid);
				userInfo.setUpdatedate(updatednow);
				System.out.println(userInfo);
				
			}else{
				userInfo = new UserInfo(jobtitle, profilephoto, address,city, country,bio,userid,updatednow);
				UserInfoOperations.insert(userInfo);
			}
		
		request.setAttribute("status", "success" );
		System.out.println("Profile Update Successful");
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
		
	}

	
	private String getFileName(Part part) {
		String contentDisposition= part.getHeader("content-disposition");
		if(!contentDisposition.contains("filename=")) {
			return null;
		}
		int beginInt =contentDisposition.indexOf("filename") +10;
		int endInt =contentDisposition.length() -1;
		String filename =contentDisposition.substring(beginInt, endInt);
		return filename;
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
